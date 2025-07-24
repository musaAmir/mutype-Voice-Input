package com.voiceinput.assistant.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import com.voiceinput.assistant.R
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class AudioVisualizerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = 0xFFFFFFFF.toInt() // Pure white
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    private val shapeCount = 4 // 3 bars + 1 circle
    private val shapeWidth = 24f // Width of each shape in dp (made larger)
    private val shapeSpacing = 32f // Spacing between shapes in dp (made larger)
    private val minShapeHeight = 32f // Minimum shape height in dp (made larger)
    private val maxShapeHeights = floatArrayOf(120f, 80f, 60f, 80f) // Max heights for each shape - circle now moves more
    private val circleRadius = 20f // Base radius for the circle (4th shape)

    private val shapeHeights = FloatArray(shapeCount) { minShapeHeight }
    private val targetHeights = FloatArray(shapeCount) { minShapeHeight }
    
    init {
        // Ensure shapes are visible from the start
        for (i in 0 until shapeCount) {
            shapeHeights[i] = minShapeHeight
        }
    }
    private val animators = mutableListOf<ValueAnimator>()

    private var isAnimating = false

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Force a reasonable size for the visualizer
        val minWidth = 200
        val minHeight = 150
        
        val width = resolveSize(minWidth, widthMeasureSpec)
        val height = resolveSize(minHeight, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerY = height / 2f
        val centerX = width / 2f
        
        // Calculate positions for 4 shapes - increased spacing for larger view
        val spacing = 48f // 1.6x larger (was 30f)
        val startX = centerX - (3 * spacing) / 2f

        for (i in 0 until shapeCount) {
            val x = startX + i * spacing
            val shapeHeight = shapeHeights[i]
            
            // Draw rounded rectangle for all bars (shapes 0, 1, 2, 3)
            val width = 19f // 1.6x larger (was 12f)
            val rect = RectF(
                x - width/2f,
                centerY - shapeHeight / 2f,
                x + width/2f,
                centerY + shapeHeight / 2f
            )
            
            // Add rounded corners
            canvas.drawRoundRect(rect, width/2f, width/2f, paint)
        }
    }

    fun startAnimation() {
        if (isAnimating) return
        isAnimating = true
        
        // Create synchronized pulsing animation for all shapes
        for (i in 0 until shapeCount) {
            animateShape(i)
        }
    }

    fun stopAnimation() {
        isAnimating = false
        
        // Stop all animators
        animators.forEach { it.cancel() }
        animators.clear()
        
        // Animate all shapes back to minimum height
        for (i in 0 until shapeCount) {
            val animator = ValueAnimator.ofFloat(shapeHeights[i], minShapeHeight).apply {
                duration = 300
                interpolator = AccelerateDecelerateInterpolator()
                addUpdateListener { animation ->
                    shapeHeights[i] = animation.animatedValue as Float
                    invalidate()
                }
            }
            animator.start()
        }
    }

    private fun animateShape(index: Int) {
        if (!isAnimating) return

        // Create random voice-like animation for each shape
        val maxHeight = maxShapeHeights[index]
        
        fun createRandomAnimation() {
            if (!isAnimating) return
            
            // Random target height between min and max
            val targetHeight = minShapeHeight + Random.nextFloat() * (maxHeight - minShapeHeight)
            
            val animator = ValueAnimator.ofFloat(shapeHeights[index], targetHeight).apply {
                duration = Random.nextLong(300, 800) // Random duration for organic feel
                interpolator = AccelerateDecelerateInterpolator()
                
                addUpdateListener { animation ->
                    shapeHeights[index] = animation.animatedValue as Float
                    invalidate()
                }
                
                addListener(object : android.animation.Animator.AnimatorListener {
                    override fun onAnimationStart(animation: android.animation.Animator) {}
                    override fun onAnimationCancel(animation: android.animation.Animator) {}
                    override fun onAnimationRepeat(animation: android.animation.Animator) {}
                    override fun onAnimationEnd(animation: android.animation.Animator) {
                        // Continue with new random animation
                        if (isAnimating) {
                            createRandomAnimation()
                        }
                    }
                })
            }
            
            animators.add(animator)
            animator.start()
        }
        
        createRandomAnimation()
    }

    fun simulateAudioInput(amplitude: Float) {
        if (!isAnimating) return
        
        // Update shapes based on audio amplitude (0.0 to 1.0)
        val normalizedAmplitude = max(0f, min(1f, amplitude))
        
        for (i in 0 until shapeCount) {
            // Each shape responds to amplitude with its own max height
            val maxHeight = maxShapeHeights[i]
            val targetHeight = minShapeHeight + (maxHeight - minShapeHeight) * normalizedAmplitude
            
            // Smooth transition to new height
            val animator = ValueAnimator.ofFloat(shapeHeights[i], targetHeight).apply {
                duration = 100
                addUpdateListener { animation ->
                    shapeHeights[i] = animation.animatedValue as Float
                    invalidate()
                }
            }
            animator.start()
        }
    }
}