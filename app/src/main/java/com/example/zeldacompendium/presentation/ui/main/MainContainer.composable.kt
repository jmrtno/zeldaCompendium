package com.example.zeldacompendium.presentation.ui.main

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zeldacompendium.presentation.ui.navigation.Destination
import com.example.zeldacompendium.presentation.ui.navigation.NavHost
import com.example.zeldacompendium.presentation.ui.navigation.NavigationIntent
import com.example.zeldacompendium.presentation.ui.navigation.composable
import com.example.zeldacompendium.presentation.ui.breath.BreathContainer
import com.example.zeldacompendium.presentation.ui.detail.DetailScreen
import com.example.zeldacompendium.presentation.ui.home.HomeContainer
import com.example.zeldacompendium.presentation.ui.tears.TearsContainer
import com.example.zeldacompendium.presentation.ui.theme.ZeldaCompendiumTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun MainContainer(
   mainViewModel: MainViewModel = hiltViewModel()
) {
   val navController = rememberNavController()
   NavigationEffects(
      navigationChannel = mainViewModel.navigationChannel,
      navHostController = navController
   )
   ZeldaCompendiumTheme {
      Surface(
         color = MaterialTheme.colorScheme.surface,
         modifier = Modifier.fillMaxSize()
      ) {
         NavHost(
            navController = navController,
            startDestination = Destination.HomeScreen
         ) {
            composable(destination = Destination.HomeScreen){
               HomeContainer()
            }
            composable(destination = Destination.BreathScreen){
               BreathContainer()
            }
            composable(destination = Destination.TearsScreen){
               TearsContainer()
            }
            composable(destination = Destination.ItemDetailsScreen) {
               DetailScreen()
            }
         }
      }
   }
}

@Composable
fun NavigationEffects(
   navigationChannel: Channel<NavigationIntent>,
   navHostController: NavHostController
) {
   val activity = (LocalContext.current as? Activity)
   LaunchedEffect(activity, navHostController, navigationChannel) {
      navigationChannel.receiveAsFlow().collect { intent ->
         if (activity?.isFinishing == true) {
            return@collect
         }
         when (intent) {
            is NavigationIntent.NavigateBack -> {
               if (intent.route != null) {
                  navHostController.popBackStack(intent.route, intent.inclusive)
               } else {
                  navHostController.popBackStack()
               }
            }
            is NavigationIntent.NavigateTo -> {
               navHostController.navigate(intent.route) {
                  launchSingleTop = intent.isSingleTop
                  intent.popUpToRoute?.let { popUpToRoute ->
                     popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                  }
               }
            }
         }
      }
   }
}