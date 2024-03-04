@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.presentation.ui.lists.breath.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.commons.GlowingCard
import com.example.zeldacompendium.presentation.ui.detail.ItemDetailModalContainer

@Composable
fun CompendiumItem(
   modifier: Modifier = Modifier,
   entry: CompendiumListEntry
) {
   val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
   var showBottomSheet by remember { mutableStateOf(false) }

   Box(modifier = modifier
      .padding(top = 30.dp)
      .clickable {
         showBottomSheet = true
      }
   ) {
      Column(
         modifier = modifier
            .zIndex(1f)
            .padding(horizontal = 40.dp),
      ) {
         ItemImage(
            modifier = modifier, imageURL = entry.imageURL, compendiumName = entry.compendiumName
         )
         Text(
            modifier = modifier.offset(y = (-19).dp),
            text = entry.compendiumName,
            fontSize = 18.sp,
            color = Color.LightGray
         )
      }
      ItemBg(
         modifier = modifier, entryNumber = entry.id
      )
   }
   if (showBottomSheet) {

      ModalBottomSheet(
         onDismissRequest = {
            showBottomSheet = false
         },
         containerColor = Color(0XFF0C0D09).copy(alpha = 0.95f),
         scrimColor = Color.Transparent,
         windowInsets = WindowInsets(
            left = 15.dp,
            right = 15.dp,
            top = 85.dp,
            bottom = 60.dp
         ),
         shape = RoundedCornerShape(20.dp),
         sheetState = sheetState
      ) {
         ItemDetailModalContainer(itemId = entry.id, game = 1)
      }
   }
}


@Composable
fun ItemImage(
   modifier: Modifier = Modifier, imageURL: String, compendiumName: String
) {
   Box(
      modifier = modifier.offset(y = (-22).dp), contentAlignment = Alignment.Center
   ) {
      AsyncImage(
         modifier = modifier
            .size(50.dp)
            .border(0.5.dp, Color.White),
         model = ImageRequest.Builder(LocalContext.current).data(imageURL)
            .placeholder(R.drawable.placeholder_img).crossfade(true).build(),
         contentDescription = compendiumName
      )
      Image(
         modifier = modifier.size(63.dp),
         painter = painterResource(id = R.drawable.frame_loaded_image),
         contentDescription = "Image frame",
      )
   }
}


@Composable
fun ItemBg(
   modifier: Modifier = Modifier, entryNumber: Int
) {
   Box(
      modifier = modifier
         .fillMaxWidth()
         .padding(horizontal = 15.dp)
   ) {
      GlowingCard(
         glowingColor = Color(0xFF005CBA), modifier = Modifier.height(75.dp), cornersRadius = 10.dp
      ) {
         Row(
            modifier = modifier
               .fillMaxWidth()
               .height(75.dp)
               .padding(end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
         ) {
            Text(
               text = "#$entryNumber", fontSize = 25.sp, color = Color.White.copy(alpha = 0.4f)
            )
         }
      }
   }
}

@Preview
@Composable
fun CompendiumItePreview() {
   /*
   CompendiumItem(
      entry = CompendiumListEntry(
         category = "creatures",
         imageURL = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/128/image",
         id = 345,
         compendiumName = "asdasdas dasdasd asdas"
      )
   )
    */
}