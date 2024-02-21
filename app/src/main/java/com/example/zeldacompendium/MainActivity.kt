package com.example.zeldacompendium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zeldacompendium.presentation.ui.detail.ItemDetailScreen
import com.example.zeldacompendium.presentation.ui.home.HomeContainer
import com.example.zeldacompendium.presentation.ui.lists.breath.BreathContainer
import com.example.zeldacompendium.presentation.ui.lists.tears.TearsContainer
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
                  "item_detail_screen/{itemId}",
                  arguments = listOf(
                     navArgument("itemId") {
                        type = NavType.IntType
                     }
                  )
               ) {
                  val itemId = remember {
                     it.arguments?.getInt("itemId")
                  }
                  ItemDetailScreen(itemId = itemId ?: 0, navController = navController)
               }
            }
         }
      }
   }
}
