package com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel

@Composable
fun Edible(
   itemInfo: ItemDetailModel,
) {
   Column {
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
