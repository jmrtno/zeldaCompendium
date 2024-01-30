package com.example.zeldacompendium.ui.selectgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zeldacompendium.R

@Composable
fun SelectCompendiumScreen(
    navController: NavController
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
    ) {
        CompendiumNavigation(navController = navController)
    }
}

@Composable
fun CompendiumNavigation(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Button(onClick = {
                navController.navigate(
                    "compendium_breath_screen"
                )
            }) {
                Text(text = "BOTW")
            }
            Button(onClick = {
                navController.navigate(
                    "compendium_tears_screen"
                )
            }) {
                Text(text = "TOTK")
            }
        }
    }
}