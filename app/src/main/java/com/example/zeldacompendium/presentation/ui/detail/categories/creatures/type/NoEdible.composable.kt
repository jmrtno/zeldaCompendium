package com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import java.util.Locale

@Composable
fun NoEdible(
   itemInfo: ItemDetailModel,
) {
   LazyColumn(
      contentPadding = PaddingValues(11.dp),
   ) {
      val dropsCount = itemInfo.data.drops
      item {
         Text(
            text = "Drops",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.LightGray.copy(alpha = 0.5f)
         )
         HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
      }
      if (!dropsCount.isNullOrEmpty()) {
         items(dropsCount.size) { drop ->
            Text(
               text = itemInfo.data.drops[drop].replaceFirstChar {
                  if (it.isLowerCase()) it.titlecase(
                     Locale.ROOT
                  ) else it.toString()
               },
               fontSize = 14.sp,
               color = Color.White
            )
         }
      } else {
         item {
            Text(
               text = "None",
               fontSize = 14.sp,
               color = Color.White
            )
         }
      }
   }
}