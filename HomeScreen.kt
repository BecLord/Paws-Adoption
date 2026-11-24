package com.example.assignment1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: DogViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.Pets,
                    contentDescription = "App Logo",
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Paws Adoption",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Find your new best friend today!",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Every dog deserves a warm, loving home. We've got wonderful furry friends waiting to meet you and become part of your family.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate(DogViewModel.Screen.DogList.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Find a Dog")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(DogViewModel.Screen.Adoption.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Adoption Info")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(DogViewModel.Screen.DogAdvice.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Dog Advice")
        }
    }
}
