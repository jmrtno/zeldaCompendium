package com.example.zeldacompendium.presentation.ui.detail.categories.materials

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.CookingEffectImageProvider

@Composable
fun MaterialsItemDetail(
   itemInfo: ItemDetailModel,
   game: Int
) {
   Row {
      Column(
         modifier = Modifier.weight(0.5f)
      ) {
         Column(
            modifier = Modifier
               .padding(11.dp)
               .weight(0.6f)
         ) {
            Text(
               text = "Healing",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
            HeartsRow(itemInfo)
         }
         HorizontalDivider()
         Column(
            modifier = Modifier
               .padding(11.dp)
               .weight(0.4f)
         ) {
            Text(
               text = "Cooking Effect",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider()
            CookingEffectColumn(itemInfo = itemInfo)
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
            val fusedPower = itemInfo.data.fuseAttackPower.toString()
            if (game == 1) {
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
            } else {
               Text(
                  text = "Fused",
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
                  color = Color.LightGray.copy(alpha = 0.5f)
               )
               HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
               Text(
                  text = "+${fusedPower} attack power",
                  fontSize = 14.sp,
                  color = Color.White
               )
            }

         }
      }
   }
}


@Composable
fun HeartsRow(
   itemInfo: ItemDetailModel,
) {
   val heartsCount = itemInfo.data.heartsRecovered.toInt()

   Row {
      repeat(heartsCount) {
         Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
            modifier = Modifier.size(22.dp)
         )
      }
      if (heartsCount == 0) {
         Image(
            painter = painterResource(id = R.drawable.empty_heart),
            contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
            modifier = Modifier.size(22.dp)
         )
      }
   }
}

@Composable
fun CookingEffectColumn(
   itemInfo: ItemDetailModel,
) {
   val imageCookingEffect = CookingEffectImageProvider.getImageResource(itemInfo.data.cookingEffect)
   Image(
      painter = painterResource(id = imageCookingEffect),
      contentDescription = "cooking effect",
      modifier = Modifier
         .fillMaxWidth()
         .size(120.dp)
   )
}