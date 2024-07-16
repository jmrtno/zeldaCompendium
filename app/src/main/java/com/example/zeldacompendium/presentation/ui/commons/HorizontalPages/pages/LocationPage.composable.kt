package com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.ServiceProvider
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.HorizontalPage



@Composable
fun LocationPage(
   itemInfo: ItemDetailModel,
   gameId: Int
){
   val locationCount = itemInfo.data.commonLocations

   HorizontalPage(text = "Location") {
      if (!locationCount.isNullOrEmpty()) {
         items(locationCount.size) {
            val commonLocation = itemInfo.data.commonLocations[it]
            Text(
               text = commonLocation,
               fontSize = 14.sp,
               color = Color.White,
               modifier = Modifier
                  .clickable {
                     ServiceProvider
                        .navigationService
                        .navigateTo("locations_map_screen/$gameId/$commonLocation")
                  }
            )
         }
      } else {
         item {
            Text(
               text = "Not defined",
               fontSize = 14.sp,
               color = Color.White
            )
         }
      }
   }
}