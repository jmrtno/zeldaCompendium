package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.HorizontalPage
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.creatures.CookingEffectImageProvider
import java.util.Locale

@Composable
fun CookingEffectPage(
   itemInfo: ItemDetailModel
){
   val imageCookingEffect = CookingEffectImageProvider.getImageResource(itemInfo.data.cookingEffect)
   HorizontalPage(text = "Cooking Effect") {
      item {
         Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
         ) {

            if (imageCookingEffect != null) {
               Image(
                  modifier = Modifier.size(40.dp).padding(end = 8.dp),
                  painter = painterResource(id = imageCookingEffect),
                  contentDescription = "cooking effect"
               )
            }
            if (itemInfo.data.cookingEffect.isNotEmpty()) {
               Text(text = itemInfo.data.cookingEffect.replaceFirstChar {
                  if (it.isLowerCase()) it.titlecase(
                     Locale.ROOT
                  ) else it.toString()
               }, color = Color.White)
            } else {
               Text(text = "None")
            }
         }
      }
   }
}

