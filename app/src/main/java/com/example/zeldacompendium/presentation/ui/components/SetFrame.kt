package com.example.zeldacompendium.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R

@Composable
fun SetFrame(){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .windowInsetsPadding(WindowInsets.safeDrawing)
   ) {
      Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
         Image(
            modifier = Modifier.fillMaxWidth().alpha(0.6f),
            painter = painterResource(R.drawable.vector_26),
            contentDescription = "vector-up",
            contentScale = ContentScale.FillBounds,
         )
         Image(
            modifier = Modifier.fillMaxWidth().alpha(0.6f).offset(y = 5.dp),
            painter = painterResource(R.drawable.vector_27),
            contentDescription = "vector_down",
            contentScale = ContentScale.FillBounds,
         )
      }
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