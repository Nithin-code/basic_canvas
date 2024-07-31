package com.nithin.basiccanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.nithin.basiccanvas.ui.theme.BasicCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicCanvasTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .drawBehind {
//
//                        }
//                )
                Scaffold { innerPadding->
                    MyCanvas(innerPadding)
                }


            }
        }
    }
}


@Composable
fun MyCanvas(innerPadding: PaddingValues) {
    Canvas(
        modifier = Modifier
            .padding(paddingValues = innerPadding)
            .padding(20.dp)
            .size(300.dp),
    ) {
        // center to the above canvas only.
        // imp : not center to screen
//        center

        drawRect(
            color = Color.Black,
            size = size // size of rectangle is size of canvas
        )
        // all the values of mentioned with f are pixel values not dp values
        drawRect(
            color = Color.Red,
            topLeft = Offset(100f,100f),
            size = Size(100f,100f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color.Red , Color.Yellow),
                center = center,
                radius = 100f
            ),
            radius = 100f,
            center = center
        )

        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = true,
            topLeft = Offset(100f,500f),
            size = Size(200f,200f)
        )

        drawOval(
            color = Color.Magenta,
            topLeft = Offset(600f,100f),
            size = Size(200f,300f)
        )

        drawLine(
            color = Color.Cyan,
            start = Offset(300f,700f),
            end = Offset(700f,700f),
            strokeWidth = 5.dp.toPx()
        )

    }
}

