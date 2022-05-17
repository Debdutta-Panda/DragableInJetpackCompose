package com.debduttapanda.dragableinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.debduttapanda.dragableinjetpackcompose.ui.theme.DragableInJetpackComposeTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragableInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                    ){
                        val d = LocalDensity.current
                        var offsetX by remember { mutableStateOf(0f) }
                        var offsetY by remember { mutableStateOf(0f) }
                        Box(
                            modifier = Modifier
                                .offset((offsetX / d.density).dp, (offsetY / d.density).dp)
                                .background(Color.Red)
                                .size(100.dp)
                                .pointerInput(Unit) {
                                    detectDragGestures { change, dragAmount ->
                                        print(dragAmount)
                                        change.consumeAllChanges()
                                        offsetX += dragAmount.x
                                        offsetY += dragAmount.y
                                    }
                                }
                        ){}
                    }
                }
            }
        }
    }
}