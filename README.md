# Paws Adoption 

Paws Adoption is an Android app built with Jetpack Compose for browsing dogs available for adoption. The project is from my Programming for Mobile Devices module in Year 3, Semester 1. 

## Features

- Browse a list of adoptable dogs
- View each dog's breed, age, gender, size, location, and description
- Submit an expression of interest with a confirmation toast
- Read a step-by-step adoption guide
- Find general nutrition, exercise, veterinary, and home-safety advice
- Navigate between screens using a bottom navigation bar and animated transitions


## Project Structure

- `MainActivity.kt` - app entry point, theme setup, navigation, top bar, and bottom navigation
- `ViewModel.kt` - navigation routes and shared dog state
- `HomeScreen.kt` - welcome screen and primary navigation actions
- `DogList.kt` - available-dog list
- `DogDetails.kt` - selected-dog profile and interest button
- `DogAdvice.kt` - general dog care advice
- `AdpotionScreen.kt` - adoption process information
- `CurrentDogs.kt` - sample dog data
- `DogClass.kt` - dog data models
- `ui/theme/` - app colors, typography, and theme

