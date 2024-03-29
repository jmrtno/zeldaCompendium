package com.example.zeldacompendium.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.commons.ImageButton
import com.example.zeldacompendium.presentation.ui.commons.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.home.component.SetFrame

@Composable
fun HomeContainer(
   navController: NavController,
){
   Surface(
      color = MaterialTheme.colorScheme.surface,
      modifier = Modifier.fillMaxSize()
   ) {
      SetBackgroundImage()
      SetFrame()
      GameNavigation(navController = navController)
   }
}

@Composable
fun GameNavigation(
   navController: NavController,
) {
   Box(
      modifier = Modifier
         .fillMaxSize(),
      contentAlignment = Alignment.Center
   ) {
      Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
         ImageButton(
            backgroundDrawableId = R.drawable.button_bg,
            border = BorderStroke(3.dp, Color(0xFF946D48)),
            onClick = {
               navController.navigate(
                  "compendium_breath_screen"
               )
            }
         ) {
            Text(text = "BOTW", color = Color(0xFF19FFFF))
         }

         ImageButton(
            backgroundDrawableId = R.drawable.button_bg,
            border = BorderStroke(3.dp, Color(0xFF946D48)),
            onClick = {
               navController.navigate(
                  "compendium_tears_screen"
               )
            }
         ) {
            Text(text = "TOTK", color = Color(0xFF19FFFF))
         }
      }
   }
}