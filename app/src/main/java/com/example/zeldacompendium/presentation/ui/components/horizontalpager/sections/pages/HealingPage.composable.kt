package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.page.HorizontalPage

@Composable
fun HealingPage(
   itemInfo: ItemDetailModel
){
   val heartsCount = itemInfo.data.heartsRecovered.toInt()
   HorizontalPage(text = "Healing") {
      item {
         Row {
            repeat(heartsCount) {
               Image(
                  painter = painterResource(id = R.drawable.heart),
                  contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
                  modifier = Modifier.size(32.dp)
               )
            }
            if (heartsCount == 0) {
               Image(
                  painter = painterResource(id = R.drawable.empty_heart),
                  contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
                  modifier = Modifier.size(32.dp)
               )
            }
         }
      }
   }
}