package com.example.zeldacompendium.presentation.ui.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.zeldacompendium.R

@Composable
fun ListHeaderImageSection(
   gameId: Int?
){
   Image(
      painter = painterResource(id = if(gameId == 1){R.drawable.logo_botw} else {R.drawable.logo_tears}),
      contentDescription = "Zelda botw Logo",
      modifier = Modifier
         .fillMaxWidth()
         .size(120.dp)
         .offset(y = -(15).dp)
   )
}
