package com.example.zeldacompendium.presentation.ui.detail.categories.monsters

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
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.ServiceProvider
import java.util.Locale

@Composable
fun MonsterItemDetail(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   Row {
      LazyColumn(
         modifier = Modifier.weight(0.5f),
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
                  val commonLocation = itemInfo.data.commonLocations[it]
                  Text(
                     text = commonLocation,
                     fontSize = 14.sp,
                     color = Color.White,
                     modifier = Modifier.clickable {
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