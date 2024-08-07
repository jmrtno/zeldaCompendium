package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.HorizontalPage
import java.util.Locale

@Composable
fun DropsPage(
   itemInfo: ItemDetailModel
){
   val dropsCount = itemInfo.data.drops

   HorizontalPage(text = "Drops") {
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