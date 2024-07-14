package com.example.zeldacompendium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zeldacompendium.domain.service.NavigationServiceImpl
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.ServiceProvider
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
               composable("compendium_tears_screen") {
                  TearsContainer(
                     navController = navController
                  )
               }
               composable("compendium_breath_screen") {
                  BreathContainer(
                     navController = navController
                  )
               }
               composable(
                  route = "locations_map_screen/{gameId}/{coordinates}",
                  arguments = listOf(
                     navArgument("gameId") { type = NavType.IntType },
                     navArgument("coordinates") { type = NavType.StringType }
                  )
               ) { backStackEntry ->
                  val gameId = backStackEntry.arguments?.getInt("gameId")
                  val coordinates = backStackEntry.arguments?.getString("coordinates")
                  if (gameId != null) {
                     LocatioMapContainer(gameId = gameId, coordinates = coordinates)
                  }
               }
            }
         }
      }
   }
}
