package com.example.zeldacompendium.presentation.ui.detail.categories.creatures

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.NavigationService
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.Edible
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.NoEdible


object ServiceProvider {
   lateinit var navigationService: NavigationService
}

@Composable
fun CreaturesItemDetail(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   Row {
      Column(
         modifier = Modifier.weight(0.5f)
      ) {
         if (!itemInfo.data.edible) {
            NoEdible(itemInfo = itemInfo)
         } else {
            Edible(itemInfo = itemInfo)
         }
      }
      VerticalDivider()
      Column(
         modifier = Modifier.weight(0.5f)
      ) {
         LazyColumn(
            contentPadding = PaddingValues(11.dp),
            modifier = Modifier.weight(0.6f)
         ) {
            val locationCount = itemInfo.data.commonLocations
            item {
               Text(
                  text = "Location",
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
                  color = Color.LightGray.copy(alpha = 0.5f)
               )
               HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
            }
            if (!locationCount.isNullOrEmpty()) {
               items(locationCount.size) {
                  Text(
                     text = itemInfo.data.commonLocations[it],
                     fontSize = 14.sp,
                     color = Color.White,
                     modifier = Modifier.clickable {
                        ServiceProvider
                           .navigationService
                           .navigateTo("locations_map_screen/$gameId")
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
         HorizontalDivider()
         Column(
            modifier = Modifier
               .padding(11.dp)
               .weight(0.4f)
         ) {
            val dlcInfo = itemInfo.data.dlc
            Text(
               text = "DLC",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
            Text(
               text = if (dlcInfo) "Yes" else "No",
               fontSize = 14.sp,
               color = Color.White
            )
         }
      }
   }
}