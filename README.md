# Grupo Jambee App

An Android application that showcases property listings for sale, adhering to **MVVM** architecture and **SOLID** principles. This project demonstrates modern Android development practices using **Jetpack Compose**, **Dagger Hilt**, **Retrofit**, and **Coil**, among others.

---

## Overview

Grupo Jambee App is designed to fetch and display real estate properties available for sale. Data is retrieved from an external API (e.g., [Easybroke](https://easybroke.com/)) and presented through a clean, user-friendly interface built entirely with Jetpack Compose.

---

## Features

- **Modern UI with Jetpack Compose**: Declarative UI components for a seamless and reactive user experience.
- **Network Calls with Retrofit**: Efficiently fetch data from remote endpoints.
- **Image Loading with Coil**: Display property images with minimal code and high performance.
- **Dependency Injection with Dagger Hilt**: Simplify the creation and provision of dependencies throughout the app.
- **MVVM Architecture**: Separate concerns between data (Model), UI (View), and business logic (ViewModel).
- **SOLID Principles**: Promote clean, maintainable, and testable code.
- **Navigation Component**: Manage in-app navigation with clear, type-safe routes.

---

## Project Structure

```
app
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ com.alexismoraportal.grupojambeeapp
 ┃ ┃   ┣ components       # Reusable UI components
 ┃ ┃   ┣ data             # Data layer (API calls, local storage, etc.)
 ┃ ┃   ┣ di               # Dependency injection setup with Hilt
 ┃ ┃   ┣ model            # Data models
 ┃ ┃   ┣ navigation       # NavGraph and routes
 ┃ ┃   ┣ repository       # Data repositories for fetching and caching
 ┃ ┃   ┣ state            # UI states and domain-specific states
 ┃ ┃   ┣ ui/theme         # Theming for Jetpack Compose
 ┃ ┃   ┣ util             # Utility classes and constants
 ┃ ┃   ┗ viewmodel        # ViewModels for handling UI logic
 ┃ ┗ resources
 ┗ build.gradle
```

- **`data`**: Houses network logic (`ApiEasy`, `PropertyDataSource`) and handles the retrieval of property listings.  
- **`di`**: Contains modules for Hilt to provide dependencies (e.g., Retrofit instance, repositories).  
- **`model`**: Defines Kotlin data classes (`PropertiesModel`, etc.).  
- **`repository`**: Mediates between data sources (network, local) and the ViewModels.  
- **`viewmodel`**: Holds the state and business logic for each screen.  
- **`ui`**: Responsible for Compose UI elements, theming, and custom components.

---

## Tech Stack

- **Kotlin 1.8+**  
- **Jetpack Compose** for modern, declarative UI.  
- **Dagger Hilt** for dependency injection.  
- **Retrofit** for network requests.  
- **Coil** for image loading.  
- **OkHttp** for HTTP client capabilities.  
- **Paging 3** for handling large data sets in a paginated way.  
- **Navigation Component** for Compose.  

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/AlexisZhuber/GrupoJambeeApp.git
   ```
2. **Open in Android Studio**:
   - File > Open > Select the cloned folder.
3. **Sync Gradle**:
   - Wait for Gradle to download dependencies.
4. **Run the app**:
   - Select an emulator or a physical device.
   - Press **Run** (▶) in Android Studio.

---

## Contributing

Contributions are welcome! Feel free to:

- Submit **issues** for bugs or feature requests.
- Create **pull requests** to improve code quality, add features, or fix bugs.

Please make sure to follow [Conventional Commits](https://www.conventionalcommits.org/) and keep the project structure consistent.

---

## License

This project is released under the [MIT License](LICENSE).  
Feel free to use, modify, and distribute it as you see fit.

---

**Enjoy exploring the code and learning about modern Android development with Jetpack Compose, MVVM, and SOLID principles!**
