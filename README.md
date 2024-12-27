# EcoEats

## EcoEats is an Android application designed to help users discover and manage eco-friendly recipes. The app is built using Kotlin and leverages modern Android development practices, including Jetpack Compose for UI, Hilt for dependency injection, and Firebase for some backend services. Other backend services such as Authentication and some storage are handled in a separate backend.

<!--- # IMAGENES Diagram or video that explain a little bit better -->
# Screenhots
![alt text](https://github.com/betolix/EcoEats/blob/main/images/001.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/002.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/003.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/004.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/005.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/006.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/007.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/008.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/010.png?raw=true)
![alt text](https://github.com/betolix/EcoEats/blob/main/images/011.png?raw=true)


<!--- ### INTRO PARAGRAPH ( SEO Value keywords ) Deeper dive -->
# A deeper dive

### Features:

Welcome Screen

OnBoarding Screens (3) - Horizontal Pager - Navigation (navigationCompose V2.8.3)

Navigation: Seamless navigation between different screens using Jetpack Navigation Compose.

Login Screen - User Authentication: Secure user authentication using a backend, Encrypted Token stored in Shared Preferences, DI ( Hilt ) for context.

Encrypted Shared Preferences: Securely store user data using encrypted shared preferences.

Scaffold ( Home Screen - Search Screen - Upload Screen ) 

Home Screen ( Recipe Discovery ): Browse a variety of eco-friendly recipes.

Detailed Recipe Screen: View detailed information about each recipe, including ingredients and nutritional information.

Search Screen: Search recipes obtained from Firebase Backend.

Upload Screen: Upload pictures and recipes.

Technologies Used

Kotlin: Primary programming language.
Jetpack Compose: Modern toolkit for building native Android UI.
Hilt: Dependency injection library for Android.
Firebase: Backend services including Firestore for database.
Coil: Image loading library for Android.
Accompanist: Libraries for Jetpack Compose, including Pager and Placeholder.

Project Structure

src/main/java/io/h3llo/ecoeats: Contains the main source code for the application.

di: Dependency injection modules.
domain: Domain models and business logic.
navigation: Navigation setup and routes.
presentation: UI components and screens.
ui/theme: Theme and styling for the application.

Getting Started
Prerequisites
Android Studio 2024.2.1 Patch 3 or later.
JDK 11 or later.
Firebase project setup with Firestore and Authentication enabled.

Installation

Clone the repository:  
git clone https://github.com/betolix/EcoEats.git
cd EcoEats
Open the project in Android Studio:  
Open Android Studio.
Select File > Open and navigate to the cloned repository.

Set up Firebase:  
Add your google-services.json file to the app directory.
Ensure Firebase dependencies are included in build.gradle files.
Build and run the project:  
Sync the project with Gradle files.
Run the project on an emulator or physical device.

Usage
Browse Recipes: Open the app and browse through the list of available recipes.
View Recipe Details: Click on a recipe to view detailed information.
Sign In: Use the sign-in screen to authenticate and access personalized features.

Contributing
Contributions are welcome! Please follow these steps to contribute:  
Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Make your changes and commit them (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature).
Open a pull request.

## known issues

Navigation does not update the selected icon from the bottom bar.

License
This project is licensed under the MIT License. See the LICENSE file for more details.  
Contact
For any questions or feedback, please contact the project maintainer at betolix@gmail.com.  
