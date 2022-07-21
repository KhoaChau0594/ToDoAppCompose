package com.khoachau.todoappcompose

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khoachau.todoappcompose.ui.theme.*

@Composable
fun TaskItem() {
    Row(modifier = Modifier.fillMaxWidth()) {
//        Image
    }
}

@Composable
fun TaskProgress(progress: Float) {
    val borderWidth = 2.dp

    @Composable
    fun handleTaskCompleted(modifier: Modifier) {
        val animatedAlpha by animateFloatAsState(targetValue = 1.0f)
        Image(
            painter = painterResource(id = R.drawable.ic_white_check),
            contentDescription = "",
            modifier = modifier
                .size(30.dp)
                .alpha(animatedAlpha),
        )
    }

    @Composable
    fun handleTaskNotStarted() {
    }

    @Composable
    fun handleTaskInProgress(progress: Float, modifier: Modifier) {
        Canvas(modifier = modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val startDegree = -90f
            val endDegree = 360f * progress

            val arcWidth = 16.dp.toPx() / 2

            val path = Path().apply {
                arcTo(
                    Rect(
                        topLeft = Offset(0f, 0f),
                        bottomRight = Offset(canvasWidth, canvasHeight)
                    ),
                    startAngleDegrees = startDegree,
                    sweepAngleDegrees = endDegree,
                    forceMoveTo = false
                )
                arcTo(
                    Rect(
                        topLeft = Offset(0f + arcWidth, 0f + arcWidth),
                        bottomRight = Offset(canvasWidth - arcWidth, canvasHeight - arcWidth)
                    ),
                    startAngleDegrees = startDegree + endDegree,
                    sweepAngleDegrees = -endDegree,
                    forceMoveTo = false
                )
                close()
            }

            drawPath(
                path = path,
                Blue500,
            )

            drawPath(
                path = path,
                Blue700,
                style = Stroke(
                    2.dp.toPx(),
                    join = StrokeJoin.Round
                ),
            )
        }
    }

    val backgroundColor by animateColorAsState(
        targetValue = when (progress) {
            0f -> Color.White
            1f -> Blue500
            else -> Blue200
        }
    )

    val borderColor by animateColorAsState(
        targetValue = when (progress) {
            0f -> Gray50
            1f -> Blue700
            else -> Blue250
        }
    )

    Box {
        Box(
            modifier = Modifier
                .size(50.dp)
                .shadow(elevation = 3.dp, shape = CircleShape)
                .border(width = borderWidth, color = borderColor, shape = CircleShape)
                .background(backgroundColor, shape = CircleShape)
        )

        when (progress) {
            0f -> {
                handleTaskNotStarted()
            }
            1f -> {
                handleTaskCompleted(Modifier.align(Alignment.Center))
            }
            else -> {
                handleTaskInProgress(
                    progress,
                    Modifier
                        .size(50.dp)
                        .padding(1.dp)
                )
            }
        }
    }

//@Composable
//fun AnimatedTaskProgress(progress: Float) {
//    val value by animateFloatAsState(targetValue = progress)
//    TaskProgress(progress = value)
//}

    @Preview
    @Composable
    fun PreviewTaskProgress() {
        Row {
            Column(Modifier.padding(10.dp)) {
                TaskProgress(progress = 0f)
                Spacer(modifier = Modifier.size(10.dp))
                TaskProgress(progress = 1f)
                Spacer(modifier = Modifier.size(10.dp))
                TaskProgress(progress = 0.4f)
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(Modifier.padding(10.dp)) {
                TaskProgress(progress = 0.1f)
                Spacer(modifier = Modifier.size(10.dp))
                TaskProgress(progress = 0.6f)
                Spacer(modifier = Modifier.size(10.dp))
                TaskProgress(progress = 0.9f)
            }
        }
    }

    @Preview
    @Composable
    fun AnimatedTaskProgressPreview() {
        var text by rememberSaveable {
            mutableStateOf("0.0")
        }

        Column(Modifier.padding(10.dp)) {
            TextField(
                value = text,
                onValueChange = {
                    if (it.isEmpty()) {
                        text = "0.0"
                    } else {
                        text = it
                    }
                },
                label = { Text(text = "Label") }
            )
            Spacer(modifier = Modifier.size(10.dp))

            val animatedProgress by animateFloatAsState(
                targetValue = text.toFloatOrNull() ?: 0.0f
            )
            TaskProgress(progress = animatedProgress)
        }
    }

    @Preview
    @Composable
    fun PreviewNoteItem() {
        TaskItem()
    }
}