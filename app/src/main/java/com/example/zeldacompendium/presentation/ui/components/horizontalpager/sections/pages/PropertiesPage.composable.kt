package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.page.HorizontalPage
import java.util.Locale

@Composable
fun PropertiesPage(
   itemInfo: ItemDetailModel,
   gameId: Int
){
   HorizontalPage(text = "Properties") {
      item {
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
}

@Composable
fun PropertiesRow(
   @DrawableRes iconRes: Int,
   contentDescription: String,
   fontSize: TextUnit,
   value: String
) {
   Row(
      modifier = Modifier.padding(vertical = 10.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp)
   ) {
      Image(
         painter = painterResource(id = iconRes),
         contentDescription = contentDescription,
         modifier = Modifier.size(24.dp)
      )
      Text(
         text = value,
         fontSize = fontSize,
         color = Color.White
      )
   }
}