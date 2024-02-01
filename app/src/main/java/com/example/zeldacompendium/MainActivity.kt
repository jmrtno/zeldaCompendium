package com.example.zeldacompendium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zeldacompendium.ui.breath.CompendiumBreathScreen
import com.example.zeldacompendium.ui.tears.CompendiumTearsScreen
import com.example.zeldacompendium.ui.selectgame.SelectGameContainer
import com.example.zeldacompendium.ui.theme.ZeldaCompendiumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         ZeldaCompendiumTheme {
            val navController = rememberNavController()
            NavHost(
               navController = navController,
               startDestination = "compendium_navigation"
            ) {
               composable("compendium_navigation"){
                  SelectGameContainer(navController = navController)
               }
               composable("compendium_tears_screen") {
                  CompendiumTearsScreen(
                     navController = navController
                  )
               }
               composable("compendium_breath_screen") {
                  CompendiumBreathScreen(
                     navController = navController
                  )
               }
            }
         }
      }
   }
}
