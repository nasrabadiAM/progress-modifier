package com.nasrabadiam.progress_modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.debugInspectorInfo

private const val PROGRESS_ALPHA_VALUE = 0.2f

fun Modifier.progressAnimation(
    durationMillis: Int,
    progressColor: Color = Color.Black,
    finishedListener: (() -> Unit)? = null
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "cancelableProgress"
        properties["durationMillis"] = durationMillis
        properties["progressColor"] = progressColor
        properties["finishedListener"] = finishedListener
    },
    factory = {
        val paint = Paint().apply {
            color = progressColor
            alpha = PROGRESS_ALPHA_VALUE
        }

        var widthValue by remember { mutableStateOf(0f) }
        val widthAnimation by animateFloatAsState(
            targetValue = widthValue,
            animationSpec = tween(durationMillis, easing = LinearEasing),
            finishedListener = { finishedListener?.invoke() }
        )

        drawWithContent {
            widthValue = size.width

            drawContent()
            inset(
                left = 0.0f,
                top = 0.0f,
                right = this.size.width - size.width,
                bottom = this.size.height - size.height
            ) {
                drawIntoCanvas { canvas ->
                    val layerRect = Rect(Offset.Zero, Size(widthAnimation, size.height))
                    canvas.drawRect(layerRect, paint)
                }
            }
        }
    }
)