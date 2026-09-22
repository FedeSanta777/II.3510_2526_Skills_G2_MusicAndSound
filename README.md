# Music & Sound — Android Launchpad

A mobile Android prototype for experimenting with **music interaction, sound triggering, and audio recording workflows** through a simple launchpad-style interface.

The project was developed as a practical exploration of Android application development with **Kotlin** and **Jetpack Compose**, with a particular focus on interactive UI design, audio-oriented software architecture, and modular separation between the interface and audio components.

The application provides a 4×4 launchpad interface designed to associate pads with different percussion and sound samples, while the project architecture also includes dedicated components for sound playback and audio recording.

---

## Project Overview

The application is structured around a digital launchpad concept.

Users interact with a grid of pads representing different sounds such as:

- Kick
- Snare
- Clap
- Hi-hat
- Open hi-hat
- Ride
- Rim
- Shaker
- Toms
- Sound effects

The project separates the application into dedicated UI and audio layers, making it possible to evolve the prototype toward a more complete beat-making and recording application.

The overall architecture can be summarized as:

```text
User Interaction
       ↓
Jetpack Compose UI
       ↓
LaunchpadScreen
       ↓
 ┌───────────────┬───────────────┐
 │               │               │
SoundEngine    Recorder
 │               │
Sound Samples   Audio Recording
```

---

## Main Features

### Interactive 4×4 Launchpad

The main interface provides a **16-pad launchpad grid** designed for triggering individual sound samples.

Each pad:

- Has its own index
- Uses a visually distinct color
- Reacts to user interaction
- Can be associated with a specific audio sample
- Is designed to trigger audio through the `SoundEngine`

The grid is implemented entirely using **Jetpack Compose**, making the UI declarative and easy to extend.

---

## Audio Sample Library

The project includes a collection of WAV audio samples used as the basis for the launchpad.

Available samples include:

```text
kick
snare
clap
hat
open hat
ride
rim
shaker
tom1
tom2
tom3
tom4
fx1
fx2
fx3
fx4
```

These resources are stored inside the Android `res/raw` directory and are intended to be dynamically connected to the launchpad pads.

---

## Sound Engine Architecture

Audio playback responsibilities are separated from the UI through the `SoundEngine` class.

```kotlin
class SoundEngine(private val context: Context)
```

The component exposes dedicated operations for:

```text
loadPad()
trigger()
release()
```

This separation keeps audio logic independent from the Compose interface and provides a clear extension point for Android audio technologies such as:

- SoundPool
- MediaPlayer
- ExoPlayer

The architecture is designed so that each launchpad pad can be associated with an audio resource and triggered independently.

---

## Recording Architecture

The project also includes a dedicated `Recorder` component responsible for the audio-recording workflow.

```kotlin
class Recorder(private val context: Context)
```

The class maintains recording state and exposes:

```text
start()
stop()
```

The interface is already connected to recording controls through the application top bar, where the icon dynamically switches between:

- Record
- Stop

The current architecture is prepared for integration with Android recording APIs such as:

- MediaRecorder
- AudioRecord

and for storing recorded audio inside application-specific storage.

---

## Jetpack Compose UI

The entire user interface is built using **Jetpack Compose**.

The application uses:

- `Scaffold`
- `TopAppBar`
- `Column`
- `Row`
- `Box`
- Material 3 components
- Compose state management
- Pointer input handling
- Dynamic UI elements
- Custom themes

The launchpad itself is generated programmatically rather than by manually defining each button.

The pad index is calculated using:

```text
index = row × number_of_columns + column
```

This makes the launchpad grid easy to resize or adapt to different layouts.

---

## UI Architecture

The main UI logic is contained in:

```text
LaunchpadScreen.kt
```

The screen is divided into reusable Compose components:

```text
LaunchpadScreen
    ↓
LaunchpadGrid
    ↓
PadCell
```

This component-based approach keeps the interface modular and separates:

- Screen-level state
- Grid generation
- Individual pad behavior
- Audio interaction

---

## Application Architecture

The project follows a simple separation of responsibilities:

```text
MainActivity
│
├── AppTheme
│
└── LaunchpadScreen
      │
      ├── SoundEngine
      │     ├── loadPad()
      │     ├── trigger()
      │     └── release()
      │
      └── Recorder
            ├── start()
            └── stop()
```

`MainActivity` initializes the audio components and injects them into the Compose UI.

This approach avoids coupling audio management directly to the interface and makes individual components easier to evolve independently.

---

## Technologies

The project is built using:

- **Kotlin**
- **Android SDK**
- **Jetpack Compose**
- **Material Design 3**
- **Gradle / Kotlin DSL**
- **Java 17**
- **Android Studio**
- **WAV audio resources**

### Android Configuration

```text
Compile SDK: 34
Target SDK: 34
Minimum SDK: 24
Java Version: 17
Kotlin JVM Target: 17
```

---

## Project Structure

```text
II.3510_2526_Skills_G2_MusicAndSound/
│
├── app/
│   │
│   ├── src/main/
│   │   │
│   │   ├── java/com/example/skillsexercise/
│   │   │   │
│   │   │   ├── MainActivity.kt
│   │   │   │
│   │   │   ├── audio/
│   │   │   │   ├── Recorder.kt
│   │   │   │   └── SoundEngine.kt
│   │   │   │
│   │   │   └── ui/
│   │   │       ├── LaunchpadScreen.kt
│   │   │       └── theme/
│   │   │
│   │   ├── res/
│   │   │   ├── raw/
│   │   │   │   ├── kick.wav
│   │   │   │   ├── snare.wav
│   │   │   │   ├── clap.wav
│   │   │   │   ├── hat.wav
│   │   │   │   ├── ohat.wav
│   │   │   │   ├── ride.wav
│   │   │   │   ├── rim.wav
│   │   │   │   ├── shaker.wav
│   │   │   │   ├── tom1.wav
│   │   │   │   ├── tom2.wav
│   │   │   │   └── ...
│   │   │   │
│   │   │   ├── drawable/
│   │   │   ├── values/
│   │   │   └── xml/
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── build.gradle.kts
│
├── Presentation/
│   └── Presentation.pdf
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## Current Development Status

The repository represents a functional **UI and software architecture prototype** for an Android music launchpad.

The Compose interface and audio component structure are already defined, while the audio engine and recording components are designed as extension points for further development.

The architecture supports future implementation of:

- Real-time sample playback
- Low-latency pad triggering
- Microphone recording
- Recording persistence
- Beat and voice-track workflows
- Saved recording playback
- Audio overdubbing
- Custom sound assignment to pads

---

## What This Project Demonstrates

This project provided practical experience in:

- Android application development
- Kotlin programming
- Jetpack Compose
- Declarative UI development
- Component-based software design
- State management
- User interaction handling
- Audio-oriented application architecture
- Android resource management
- Separation of UI and application logic
- Gradle-based Android project configuration

It also explores how a mobile application can be structured around media-oriented requirements while maintaining clear separation between presentation and audio-processing responsibilities.

---

## Possible Future Improvements

The current architecture can be extended with several features:

- SoundPool-based low-latency sample playback
- Runtime microphone permissions
- MediaRecorder or AudioRecord integration
- Beat recording
- Voice recording
- Audio track mixing
- Overdubbing
- Custom sample import
- Recording management
- Playback controls
- Waveform visualization
- BPM synchronization
- Persistent project storage

---

## Author

**Federico Santavicca**

Master's student in Engineering in Computer Science at Sapienza University of Rome.

Main areas of interest:

- Artificial Intelligence
- Software Engineering
- Mobile Development
- Machine Learning
- Computer Vision
- Generative AI
