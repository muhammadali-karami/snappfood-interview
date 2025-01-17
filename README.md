# SnappFood Android Case Study

## Overview
This project implements a Star Wars character search app using Kotlin and Jetpack Compose.

### Features
- Search for Star Wars characters.
- View detailed information about characters.
- Displays information like name, height, species, and movies.

### Technologies
- **Kotlin**
- **Jetpack Compose**
- **Retrofit** for API communication
- **Hilt** for Dependency Injection
- **StateFlow** for reactive state management

### Architecture
The project uses the MVVM architecture:
- **UI Layer**: Composables handle the presentation logic.
- **ViewModel**: Manages state and interacts with the repository.
- **Repository**: Encapsulates API communication.

### How to Run
1. Clone the repository.
2. Open the project in Android Studio.
3. Sync Gradle dependencies.
4. Build and run the app on an emulator or device.

### API
Data is fetched from the [SWAPI](https://swapi.dev/).

### Improvements
- Enhanced error handling using a sealed class (`ApiResult`).
- Loading states for better user experience.
