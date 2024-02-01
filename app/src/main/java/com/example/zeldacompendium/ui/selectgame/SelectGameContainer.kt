package com.example.zeldacompendium.ui.selectgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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

@Composable
fun SetBackgroundImage() {
   Box(modifier = Modifier.fillMaxSize()) {
      Image(
         modifier = Modifier.matchParentSize(),
         painter = painterResource(id = R.drawable.fondo_compendiumapp),
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
