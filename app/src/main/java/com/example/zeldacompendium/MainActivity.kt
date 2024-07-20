package com.example.zeldacompendium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zeldacompendium.domain.service.NavigationServiceImpl
import com.example.zeldacompendium.domain.service.ServiceProvider
import com.example.zeldacompendium.presentation.ui.home.HomeContainer
import com.example.zeldacompendium.presentation.ui.lists.breath.BreathContainer
import com.example.zeldacompendium.presentation.ui.lists.tears.TearsContainer
import com.example.zeldacompendium.presentation.ui.locationsmap.LocatioMapContainer
import com.example.zeldacompendium.presentation.ui.theme.ZeldaCompendiumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      WindowCompat.setDecorFitsSystemWindows(window, false)
      window.statusBarColor = getColor(R.color.black)
      setContent {
         ZeldaCompendiumTheme {
            val navController = rememberNavController()
            val navigationService = NavigationServiceImpl(navController)
            ServiceProvider.navigationService = navigationService
            NavHost(
               navController = navController,
               startDestination = "compendium_navigation"
            ) {
               composable("compendium_navigation") {
                  HomeContainer(navController = navController)
               }
               composable(
                  route = "compendium_screen/{gameId}",
                  arguments = listOf(
                     navArgument("gameId") { type = NavType.IntType },
                  )
               ) { entry ->
                  val gameId = entry.arguments?.getInt("gameId")
                  if (gameId == 1) {
                     BreathContainer(
                        navController = navController,
                        gameId = gameId
                     )
                  } else {
                     TearsContainer(
                        navController = navController,
                        gameId = gameId
                     )
                  }
               }
               composable(
                  route = "locations_map_screen/{gameId}/{coordinates}",
                  arguments = listOf(
                     navArgument("gameId") { type = NavType.IntType },
                     navArgument("coordinates") { type = NavType.StringType }
                  )
               ) { entry ->
                  val gameId = entry.arguments?.getInt("gameId")
                  val coordinates = entry.arguments?.getString("coordinates")
                  if (gameId != null) {
                     LocatioMapContainer(gameId = gameId, coordinates = coordinates)
                  }
               }
            }
         }
      }
   }
}
