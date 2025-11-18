package com.example.skillsexercise.audio

import android.content.Context
import android.util.Log

/**
 * Handles loading and playback of pad sounds.
 * Currently a stub that only logs actions.
 */
class SoundEngine(private val context: Context) {

    // Map (padId -> sound handle)
    // TODO(students): replace Any with a real handle (e.g., SoundPool soundId)
    private val padHandles = mutableMapOf<Int, Any>()

    fun loadPad(padId: Int, source: Any) {
        // TODO(students): implement loading using SoundPool/MediaPlayer/ExoPlayer
        Log.d("SoundEngine", "loadPad($padId, $source) [TODO]")
        padHandles[padId] = source
    }

    fun trigger(padId: Int) {
        // TODO(students): play the loaded sound for this pad
        Log.d("SoundEngine", "trigger($padId) [TODO]")
    }

    fun release() {
        // TODO(students): release audio resources
        padHandles.clear()
        Log.d("SoundEngine", "release() [TODO]")
    }
}
