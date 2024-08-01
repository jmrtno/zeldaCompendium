package com.example.zeldacompendium.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.zeldacompendium.R

@Composable
fun SetBackgroundImage() {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .windowInsetsPadding(WindowInsets.safeDrawing),
   ) {
      Image(
         modifier = Modifier.matchParentSize(),
         painter = painterResource(R.drawable.main_bg),
         contentDescription = "bg",
         contentScale = ContentScale.None,
      )
      Image(
         modifier = Modifier.matchParentSize().alpha(0.3f),
         painter = painterResource(R.drawable.lines_bg),
         contentDescription = "lines_bg",
         contentScale = ContentScale.FillBounds,
      )
   }
}