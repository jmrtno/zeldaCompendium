package com.example.zeldacompendium.presentation.ui.selectgame.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.zeldacompendium.R

@Composable
fun SetFrame(){
   Box(
      modifier = Modifier.fillMaxSize(),
   ) {
      Image(
         alignment = Alignment.TopStart,
         painter = painterResource(R.drawable.up_frame_big),
         contentDescription = "up_frame_big",
         contentScale = ContentScale.None,
      )

      Image(
         alignment = Alignment.TopEnd,
         painter = painterResource(R.drawable.right_up_frame),
         contentDescription = "right_up_frame",
         contentScale = ContentScale.None,
      )

      Image(
         modifier = Modifier
            .align(Alignment.BottomEnd),
         alignment = Alignment.BottomEnd,
         painter = painterResource(R.drawable.down_frame_big),
         contentDescription = "down_frame_big",
         contentScale = ContentScale.None,
      )

      Image(
         modifier = Modifier
            .align(Alignment.BottomStart),
         alignment = Alignment.BottomStart,
         painter = painterResource(R.drawable.left_down_frame),
         contentDescription = "left_down_frame",
         contentScale = ContentScale.None,
      )
   }
}