package com.example.zeldacompendium.presentation.ui.detail.categories.equipment

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import java.util.Locale

@Composable
fun EquipmentItemDetail(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   Row {
      LazyColumn(
         modifier = Modifier
            .padding(11.dp)
            .weight(0.5f),
      ) {
         item {
            Text(
               text = "Properties",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
            PropertiesRow(
               iconRes = R.drawable.attack_icon,
               contentDescription = "attack_icon",
               fontSize = 24.sp,
               value = itemInfo.data.properties.attack.toString()
            )
            PropertiesRow(
               iconRes = R.drawable.defense_icon,
               contentDescription = "defense_icon",
               fontSize = 24.sp,
               value = itemInfo.data.properties.defense.toString()
            )
            if (gameId != 1) {
               PropertiesRow(
                  iconRes = R.drawable.effect_icon,
                  contentDescription = "effect_icon",
                  fontSize = 14.sp,
                  value = itemInfo.data.properties.effect.replaceFirstChar {
                     if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                     ) else it.toString()
                  },
               )
               PropertiesRow(
                  iconRes = R.drawable.type_icon,
                  contentDescription = "type_icon",
                  fontSize = 14.sp,
                  value = itemInfo.data.properties.type.replaceFirstChar {
                     if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                     ) else it.toString()
                  },
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

@Composable
fun PropertiesRow(
   @DrawableRes iconRes: Int,
   contentDescription: String,
   fontSize: TextUnit,
   value: String
) {
   Row(
      modifier = Modifier.padding(vertical = 15.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp)
   ) {
      Image(
         painter = painterResource(id = iconRes),
         contentDescription = contentDescription,
         modifier = Modifier.size(32.dp)
      )
      Text(
         text = value,
         fontSize = fontSize,
         color = Color.White
      )
   }
}