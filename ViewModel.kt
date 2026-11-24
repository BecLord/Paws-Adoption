package com.example.assignment1

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DogViewModel : ViewModel() {
    private val _dogs = MutableStateFlow<List<Dog>>(CurrentDogs.Dogs)
    val dogs: StateFlow<List<Dog>> = _dogs.asStateFlow()

    private val _selectedDog = MutableStateFlow<Dog?>(null)
    val selectedDog: StateFlow<Dog?> = _selectedDog.asStateFlow()

    fun selectDog(dog: Dog) {
        _selectedDog.value = dog
    }

    sealed class Screen(val route: String) {
        object Home : Screen("homeScreen")
        object DogList : Screen("dogList")
        object DogDetail : Screen("dogDetail")
        object DogAdvice : Screen("dogAdvice")
        object Adoption : Screen("adoption")
    }

    data class NavItem(
        val label: String,
        val iconId: ImageVector,
        val route: String
    )

    val navItems = listOf(
        NavItem(label = "Home", iconId = Icons.Default.Home, route = Screen.Home.route),
        NavItem(label = "Dog List", iconId = Icons.Default.Description, route = Screen.DogList.route),
        NavItem(label = "Dog Advice", iconId = Icons.Default.AutoAwesome, route = Screen.DogAdvice.route),
        NavItem(label = "Adoption", iconId = Icons.Default.Favorite, route = Screen.Adoption.route)
    )
}
