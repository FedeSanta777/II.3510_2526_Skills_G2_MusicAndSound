package com.example.skillsexercise.audio

import android.content.Context
import android.widget.Toast

/**
 * Simple audio recording stub.
 * For now it only shows a Toast when start/stop is called.
 */
class Recorder(private val context: Context) {

    var isRecording: Boolean = false
        private set

    fun start() {
        // TODO(students):
        // 1) Request RECORD_AUDIO permission (runtime)
        // 2) Initialize MediaRecorder or AudioRecord
        // 3) Configure source/format/output and start
        Toast.makeText(context, "Start recording [TODO]", Toast.LENGTH_SHORT).show()
        isRecording = true
    }

    fun stop() {
        // TODO(students):
        // 1) Stop and release recorder
        // 2) Save to getExternalFilesDir()/recordings
        Toast.makeText(context, "Stop recording [TODO]", Toast.LENGTH_SHORT).show()
        isRecording = false
    }
}
