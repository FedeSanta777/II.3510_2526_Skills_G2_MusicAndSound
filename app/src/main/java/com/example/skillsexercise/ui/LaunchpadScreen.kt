package com.example.skillsexercise.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.skillsexercise.audio.Recorder
import com.example.skillsexercise.audio.SoundEngine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchpadScreen(
    soundEngine: SoundEngine,
    recorder: Recorder
) {
    var gridSize by remember { mutableStateOf(4) } // 4x4 grid

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Launchpad Exercise") },
                actions = {
                    IconButton(
                        onClick = {
                            // TODO(students): replace with actual start/stop recording logic
                            if (!recorder.isRecording) recorder.start() else recorder.stop()
                        }
                    ) {
                        Icon(
                            imageVector = if (recorder.isRecording) Icons.Filled.Stop else Icons.Filled.Mic,
                            contentDescription = if (recorder.isRecording) "Stop" else "Record"
                        )
                    }
                }
            )
        }
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Launchpad (sounds not connected) — tap pads to simulate a trigger",
                style = MaterialTheme.typography.bodyMedium
            )

            LaunchpadGrid(
                rows = gridSize,
                cols = gridSize,
                cellSize = 72.dp,
                gap = 12.dp,
                onPadPressed = { index ->
                    // TODO(students): connect to real sound trigger
                    // soundEngine.trigger(index)
                }
            )

            ElevatedCard {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Tasks for students:", style = MaterialTheme.typography.titleSmall)
                    Text("• Connect samples to pads (SoundPool/MediaPlayer/ExoPlayer).")
                    Text("• Implement recording in Recorder (permissions + MediaRecorder).")
                    Text("• (Optional) Overdub a backing beat while recording.")
                    Text("• (Optional) Show and play saved recordings.")
                }
            }
        }
    }
}

@Composable
private fun LaunchpadGrid(
    rows: Int,
    cols: Int,
    cellSize: Dp,
    gap: Dp,
    onPadPressed: (index: Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(gap),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(rows) { r ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(gap),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(cols) { c ->
                    val index = r * cols + c
                    val scale by animateFloatAsState(targetValue = 1f, label = "padScale")
                    PadCell(
                        label = "${index + 1}",
                        color = padColor(index),
                        size = cellSize,
                        scale = scale,
                        onDown = { onPadPressed(index) },
                        onUp = { /* no-op */ }
                    )
                }
            }
        }
    }
}

@Composable
private fun PadCell(
    label: String,
    color: Color,
    size: Dp,
    scale: Float,
    onDown: () -> Unit,
    onUp: () -> Unit
) {
    val interaction = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .size(size)
            .scale(scale)
            .background(color, RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = interaction,
                indication = null,
                onClick = { /* handled by pointerInput below if you want press states */ }
            )
            .pointerInput(Unit) {
                onDown(); onUp()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = Color.Black, style = MaterialTheme.typography.titleMedium)
    }
}

private fun padColor(index: Int): Color {
    val palette = listOf(
        Color(0xFFFFC857), Color(0xFF5BC0EB), Color(0xFFFF5A5F), Color(0xFF9BC53D)
    )
    return palette[index % palette.size]
}


