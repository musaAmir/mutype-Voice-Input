package com.voiceinput.assistant.data.audio

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import androidx.core.app.ActivityCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioRecorder @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private var audioRecord: AudioRecord? = null
    private var isRecording = false
    private val audioData = ByteArrayOutputStream()
    
    companion object {
        private const val SAMPLE_RATE = 16000
        private const val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
        private const val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
        private const val BUFFER_SIZE_FACTOR = 2
    }
    
    suspend fun startRecording() = withContext(Dispatchers.IO) {
        if (isRecording) return@withContext
        
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            throw SecurityException("Audio recording permission not granted")
        }
        
        // Clear previous audio data
        audioData.reset()
        
        val bufferSize = AudioRecord.getMinBufferSize(
            SAMPLE_RATE,
            CHANNEL_CONFIG,
            AUDIO_FORMAT
        ) * BUFFER_SIZE_FACTOR
        
        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            SAMPLE_RATE,
            CHANNEL_CONFIG,
            AUDIO_FORMAT,
            bufferSize
        )
        
        audioRecord?.let { recorder ->
            if (recorder.state == AudioRecord.STATE_INITIALIZED) {
                recorder.startRecording()
                isRecording = true
                
                // Start recording in background
                val buffer = ByteArray(bufferSize)
                while (isRecording) {
                    val bytesRead = recorder.read(buffer, 0, buffer.size)
                    if (bytesRead > 0) {
                        audioData.write(buffer, 0, bytesRead)
                    }
                }
            } else {
                throw IllegalStateException("AudioRecord initialization failed")
            }
        }
    }
    
    suspend fun stopRecording(): ByteArray = withContext(Dispatchers.IO) {
        isRecording = false
        
        audioRecord?.let { recorder ->
            if (recorder.state == AudioRecord.STATE_INITIALIZED) {
                recorder.stop()
                recorder.release()
            }
        }
        
        audioRecord = null
        
        val recordedData = audioData.toByteArray()
        audioData.reset()
        
        // Convert raw PCM to WAV format for API compatibility
        return@withContext convertToWav(recordedData)
    }
    
    private fun convertToWav(pcmData: ByteArray): ByteArray {
        val wavHeader = createWavHeader(pcmData.size)
        val wavData = ByteArray(wavHeader.size + pcmData.size)
        
        System.arraycopy(wavHeader, 0, wavData, 0, wavHeader.size)
        System.arraycopy(pcmData, 0, wavData, wavHeader.size, pcmData.size)
        
        return wavData
    }
    
    private fun createWavHeader(pcmDataSize: Int): ByteArray {
        val header = ByteArray(44)
        val totalDataLen = pcmDataSize + 36
        val bitRate = SAMPLE_RATE * 1 * 16
        
        header[0] = 'R'.toByte()
        header[1] = 'I'.toByte()
        header[2] = 'F'.toByte()
        header[3] = 'F'.toByte()
        header[4] = (totalDataLen and 0xff).toByte()
        header[5] = (totalDataLen shr 8 and 0xff).toByte()
        header[6] = (totalDataLen shr 16 and 0xff).toByte()
        header[7] = (totalDataLen shr 24 and 0xff).toByte()
        header[8] = 'W'.toByte()
        header[9] = 'A'.toByte()
        header[10] = 'V'.toByte()
        header[11] = 'E'.toByte()
        header[12] = 'f'.toByte()
        header[13] = 'm'.toByte()
        header[14] = 't'.toByte()
        header[15] = ' '.toByte()
        header[16] = 16
        header[17] = 0
        header[18] = 0
        header[19] = 0
        header[20] = 1
        header[21] = 0
        header[22] = 1
        header[23] = 0
        header[24] = (SAMPLE_RATE and 0xff).toByte()
        header[25] = (SAMPLE_RATE shr 8 and 0xff).toByte()
        header[26] = (SAMPLE_RATE shr 16 and 0xff).toByte()
        header[27] = (SAMPLE_RATE shr 24 and 0xff).toByte()
        header[28] = (bitRate / 8 and 0xff).toByte()
        header[29] = (bitRate / 8 shr 8 and 0xff).toByte()
        header[30] = (bitRate / 8 shr 16 and 0xff).toByte()
        header[31] = (bitRate / 8 shr 24 and 0xff).toByte()
        header[32] = 2
        header[33] = 0
        header[34] = 16
        header[35] = 0
        header[36] = 'd'.toByte()
        header[37] = 'a'.toByte()
        header[38] = 't'.toByte()
        header[39] = 'a'.toByte()
        header[40] = (pcmDataSize and 0xff).toByte()
        header[41] = (pcmDataSize shr 8 and 0xff).toByte()
        header[42] = (pcmDataSize shr 16 and 0xff).toByte()
        header[43] = (pcmDataSize shr 24 and 0xff).toByte()
        
        return header
    }
}