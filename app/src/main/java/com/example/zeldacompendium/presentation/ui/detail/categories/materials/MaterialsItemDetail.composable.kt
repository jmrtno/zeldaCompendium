package com.example.zeldacompendium.presentation.ui.detail.categories.materials

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import java.util.Locale

@Composable
fun MaterialsItemDetail(
   itemInfo: ItemDetailModel,
){
   Box {
      HorizontalDivider(
         modifier = Modifier
            .padding(bottom = 7.dp)
            .align(Alignment.Center)
      )
      VerticalDivider(
         modifier = Modifier
            .padding(bottom = 7.dp)
            .align(Alignment.Center)
      )
      Column {
         Row(
            modifier = Modifier
               .height(140.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
         ) {
            Box(modifier = Modifier
               .weight(0.5f)
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

            LazyColumn(
               contentPadding = PaddingValues(11.dp),
               modifier = Modifier.weight(0.5f)
            ) {
               item {
                  Text(
                     text = "Category",
                     fontWeight = FontWeight.Bold,
                     fontStyle = FontStyle.Italic,
                     color = Color.LightGray.copy(alpha = 0.5f)
                  )
                  HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
               }
               item {
                  Text(
                     text = itemInfo.data.category.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                           Locale.ROOT
                        ) else it.toString()
                     },
                     fontSize = 14.sp,
                     color = Color.White
                  )
               }
            }
         }
         Row(
            modifier = Modifier
               .height(140.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
         ) {
            LazyColumn(
               contentPadding = PaddingValues(11.dp),
               modifier = Modifier.weight(0.5f)
            ) {
               val dlcInfo = itemInfo.data.dlc
               item {
                  Text(
                     text = "DLC",
                     fontWeight = FontWeight.Bold,
                     fontStyle = FontStyle.Italic,
                     color = Color.LightGray.copy(alpha = 0.5f)
                  )
                  HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
               }
               if (dlcInfo) {
                  item {
                     Text(
                        text = "From DLC",
                        fontSize = 14.sp,
                        color = Color.White
                     )
                  }
               } else {
                  item {
                     Text(
                        text = "Not from DLC",
                        fontSize = 14.sp,
                        color = Color.White
                     )
                  }
               }
            }
            LazyColumn(
               contentPadding = PaddingValues(11.dp),
               modifier = Modifier.weight(0.5f)
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
                        color = Color.White
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
      }
   }
}