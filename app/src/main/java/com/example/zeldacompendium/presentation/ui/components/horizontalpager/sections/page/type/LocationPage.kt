package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.ServiceProvider
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.HorizontalPage

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
            Row(
               modifier = Modifier
                  .fillMaxWidth()
                  .padding(bottom = 5.dp)
                  .clickable {
                     ServiceProvider
                     .navigationService
                     .navigateTo("locations_map_screen/$gameId/$commonLocation") },
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
            ) {
               Text(
                  text = commonLocation,
                  fontSize = 14.sp,
                  textDecoration = TextDecoration.Underline,
                  color = Color.White
               )
               Image(
                  painter = painterResource(R.drawable.map_icon),
                  contentDescription = "Map icon"
               )
            }
         }
      } else {
         item {
            Text(
               text = "Unknown",
               fontSize = 14.sp,
               color = Color.White
            )
         }
      }
   }
}