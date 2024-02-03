package com.example.zeldacompendium.ui.selectgame

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
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
      SetFrame()
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
   Box(
      modifier = Modifier.fillMaxSize(),
   ) {
      Image(
         modifier = Modifier.matchParentSize(),
         painter = painterResource(R.drawable.main_bg_2),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )
   }
}

@Composable
fun SetFrame(){
   Box(
      modifier = Modifier.fillMaxSize(),
   ) {
      Image(
         alignment = Alignment.TopStart,
         painter = painterResource(R.drawable.left_up_frame_big),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )

      Image(
         alignment = Alignment.TopEnd,
         painter = painterResource(R.drawable.right_up_frame),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )

      Image(
         modifier = Modifier
            .align(Alignment.BottomEnd),
         alignment = Alignment.BottomEnd,
         painter = painterResource(R.drawable.right_down_frame_big),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )

      Image(
         modifier = Modifier
            .align(Alignment.BottomStart),
         alignment = Alignment.BottomStart,
         painter = painterResource(R.drawable.left_down_frame),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )
   }
}

@Preview
@Composable
fun SelectGameContainerPreview() {
   val navController = rememberNavController()
   SelectGameContainer(navController = navController)
}
