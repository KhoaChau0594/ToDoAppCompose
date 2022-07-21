package com.khoachau.todoappcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khoachau.todoappcompose.ui.theme.Blue700

@Composable
@Preview
fun DrawInDuplicateSpace() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        drawRect(
            color = Color.Green,
            topLeft = Offset(0f, 0f),
            size = Size(200.dp.toPx(), 200.dp.toPx())
        )

        drawRect(
            color = Color.Red,
            topLeft = Offset(40.dp.toPx(), 40.dp.toPx()),
            size = Size(200.dp.toPx(), 200.dp.toPx())
        )
    }
}

@Composable
@Preview
fun DrawLine() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = 3.dp.toPx()
        )
    }
}

@Composable
@Preview
fun DrawRect() {
    Canvas(modifier = Modifier.size(220.dp, 220.dp)) {
        drawRect(
            color = Color.Green,
            topLeft = Offset(0f, 0f),
            size = Size(200.dp.toPx(), 200.dp.toPx())
        )
    }
}

@Composable
@Preview
fun DrawTriangle() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        val path = Path().apply {
            moveTo(size.width / 2, 10.dp.toPx())
            lineTo(240.dp.toPx(), 200.dp.toPx())
            lineTo(90.dp.toPx(), 200.dp.toPx())
            close()
        }

        drawPath(path = path, color = Color.Green)

        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                3.dp.toPx()
            ),
        )
    }
}


@Composable
@Preview
fun DrawArc() {
    Box(Modifier.size(250.dp, 250.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path()
            path.arcTo(
                Rect(
                    topLeft = Offset(10.dp.toPx(), 10f.dp.toPx()),
                    bottomRight = Offset(
                        size.width - 10.dp.toPx(),
                        size.height - 10.dp.toPx()
                    )
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 120f,
                forceMoveTo = false
            )

            drawPath(
                path = path,
                Blue700,
                style = Stroke(
                    3.dp.toPx(),
                    join = StrokeJoin.Round
                ),
            )
        }
    }
}


@Preview
@Composable
fun DrawArc2() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        val path = Path().apply {
            moveTo(10.dp.toPx(), 10.dp.toPx())
            lineTo(30.dp.toPx(), 10.dp.toPx())

            arcTo(
                Rect(
                    topLeft = Offset(10.dp.toPx(), 10f.dp.toPx()),
                    bottomRight = Offset(
                        size.width - 10.dp.toPx(),
                        size.height - 10.dp.toPx()
                    )
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 120f,
                forceMoveTo = false
            )

            close()
        }

        drawPath(
            path = path,
            color = Blue700,
            style = Stroke(
                3.dp.toPx(),
                join = StrokeJoin.Round
            ),
        )
    }
}


@Preview
@Composable
fun DrawCubic() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        val path = Path().apply {
            moveTo(10.dp.toPx(), 10.dp.toPx())
            lineTo(30.dp.toPx(), 10.dp.toPx())

            arcTo(
                Rect(
                    topLeft = Offset(10.dp.toPx(), 10f.dp.toPx()),
                    bottomRight = Offset(
                        size.width - 10.dp.toPx(),
                        size.height - 10.dp.toPx()
                    )
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 120f,
                forceMoveTo = false
            )

            close()
        }

        drawPath(
            path = path,
            color = Blue700,
            style = Stroke(
                3.dp.toPx(),
                join = StrokeJoin.Round
            ),
        )
    }
}


@Preview
@Composable
fun CanvasTransformation() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        withTransform({
            translate(left = size.width / 2f, top = size.height / 2f)
        }) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = 0f, y = 0f),
                size = Size(50.dp.toPx(), 50.dp.toPx())
            )
        }
        /*
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = size.width / 2f, y = size.height / 2f),
            size = Size(50.dp.toPx(), 50.dp.toPx())
        )
        */
    }
}


@Preview
@Composable
fun CanvasTransformation2() {
    Canvas(modifier = Modifier.size(250.dp, 250.dp)) {
        withTransform({

        }) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = 0f, y = 0f),
                size = Size(50.dp.toPx(), 50.dp.toPx())
            )
        }
    }
}