package com.example.assignment1

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.core.tween
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                MainFunction()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFunction(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel: DogViewModel = viewModel()
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val title = when (currentRoute) {
        DogViewModel.Screen.DogList.route -> "Dog List"
        DogViewModel.Screen.DogDetail.route -> "Dog Details"
        DogViewModel.Screen.DogAdvice.route -> "Dog Advice"
        DogViewModel.Screen.Adoption.route -> "Adoption Info"
        else -> "Paws Adoption"
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = title, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                tonalElevation = 0.dp
            ) {
                viewModel.navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            if (navController.currentDestination?.route != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(DogViewModel.Screen.Home.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.iconId,
                                contentDescription = item.label
                            )
                        },
                        label = {
                            Text(text = item.label)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.tertiary,
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                            selectedTextColor = MaterialTheme.colorScheme.tertiary,
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = DogViewModel.Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
            enterTransition = { fadeIn(animationSpec = tween(300)) + slideInHorizontally(initialOffsetX = { 300 }, animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) + slideOutHorizontally(targetOffsetX = { -300 }, animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) + slideInHorizontally(initialOffsetX = { -300 }, animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) + slideOutHorizontally(targetOffsetX = { 300 }, animationSpec = tween(300)) }
        ) {
            composable(DogViewModel.Screen.Home.route) {
                HomeScreen(navController, viewModel)
            }
            composable(DogViewModel.Screen.DogList.route) {
                DogListScreen(navController, viewModel)
            }
            composable(DogViewModel.Screen.DogDetail.route) {
                DogDetailScreen(navController, viewModel)
            }
            composable(DogViewModel.Screen.DogAdvice.route) {
                DogAdviceScreen(navController, viewModel)
            }
            composable(DogViewModel.Screen.Adoption.route) {
                AdoptionScreen(navController, viewModel)
            }
        }
    }
}
