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

The project is structured following Clean Architecture principles:

- **Presentation Layer**: Contains UI components and ViewModels.
- **Domain Laye**: Contains use cases and business logic.
- **Data Layer**: Contains repositories and data sources.

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
- Modularized codebase for better scalability and maintainability.
- Added interfaces for use cases and repository to facilitate unit testing in the future.
