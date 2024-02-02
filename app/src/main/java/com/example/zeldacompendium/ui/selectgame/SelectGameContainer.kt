package com.example.zeldacompendium.ui.selectgame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.ui.ImageButton

@Composable
fun SelectGameContainer(
   navController: NavController
) {
   Surface(
      color = MaterialTheme.colorScheme.surface,
      modifier = Modifier.fillMaxSize()
   ) {
      SetBackgroundImage()
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
            Text(text = "BOTW", color = Color(0xFFBB8F0B))
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
            Text(text = "TOTK", color = Color(0xFFBB8F0B))
         }
      }
   }
}

@Composable
fun SetBackgroundImage() {
   Box(modifier = Modifier.fillMaxSize()) {
      Image(
         modifier = Modifier.matchParentSize(),
         painter = painterResource(id = R.drawable.mainscreen_bg),
         contentDescription = "background",
         contentScale = ContentScale.FillBounds
      )
   }

}

@Preview
@Composable
fun SelectGameContainerPreview() {
   val navController = rememberNavController()
   SelectGameContainer(navController = navController)
}
