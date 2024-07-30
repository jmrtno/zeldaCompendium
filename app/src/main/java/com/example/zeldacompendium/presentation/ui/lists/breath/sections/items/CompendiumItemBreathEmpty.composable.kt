package com.example.zeldacompendium.presentation.ui.lists.breath.sections.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.components.GlowingCard

@Composable
fun CompendiumItemBreathEmpty(
   modifier: Modifier = Modifier
) {

   Box(modifier = modifier
      .padding(top = 30.dp)
   ) {
      Column(
         modifier = modifier
            .zIndex(1f)
            .padding(horizontal = 40.dp),
      ) {
         ItemImageEmpty(
            modifier = modifier
         )
         Text(
            modifier = modifier.offset(y = (-19).dp),
            text = "Item does not exist",
            fontSize = 18.sp,
            color = Color.LightGray
         )
      }
      ItemBgEmpty(
         modifier = modifier
      )
   }
}

@Composable
fun ItemImageEmpty(
   modifier: Modifier = Modifier,
) {
   Box(
      modifier = modifier.offset(y = (-22).dp),
      contentAlignment = Alignment.Center
   ) {
      Image(
         modifier = modifier
            .size(50.dp)
            .border(0.5.dp, Color.White),
         painter = painterResource(id = R.drawable.placeholder_img),
         contentDescription = "placeholder"
      )
      Image(
         modifier = modifier.size(63.dp),
         painter = painterResource(id = R.drawable.frame_loaded_image),
         contentDescription = "Image frame",
      )
   }
}

@Composable
fun ItemBgEmpty(
   modifier: Modifier = Modifier
) {
   Box(
      modifier = modifier
         .fillMaxWidth()
         .padding(horizontal = 15.dp)
   ) {
      GlowingCard {
         Row(
            modifier = modifier
               .fillMaxWidth()
               .height(75.dp)
               .padding(end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
         ) {
            Text(text = "#",
               fontSize = 25.sp,
               color = Color.White.copy(alpha = 0.4f))
         }
      }
   }
}

@Preview
@Composable
fun CompendiumItemBreathEmptyPreview() {
   CompendiumItemBreathEmpty()
}