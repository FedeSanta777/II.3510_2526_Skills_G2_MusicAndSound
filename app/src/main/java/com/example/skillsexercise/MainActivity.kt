package com.example.skillsexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.skillsexercise.audio.Recorder
import com.example.skillsexercise.audio.SoundEngine
import com.example.skillsexercise.ui.LaunchpadScreen
import com.example.skillsexercise.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEngine = SoundEngine(this) // stub
        val recorder = Recorder(this)       // stub

        setContent {
            AppTheme {
                LaunchpadScreen(
                    soundEngine = soundEngine,
                    recorder = recorder
                )
            }
        }
    }
}
