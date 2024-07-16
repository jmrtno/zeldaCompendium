package com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.HorizontalPage
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.CookingEffectImageProvider

@Composable
fun CookingEffectPage(
   itemInfo: ItemDetailModel
){
   val imageCookingEffect = CookingEffectImageProvider.getImageResource(itemInfo.data.cookingEffect)
   HorizontalPage(text = "Cooking Effect") {
      item {
         Image(
            painter = painterResource(id = imageCookingEffect),
            contentDescription = "cooking effect",
            modifier = Modifier
               .size(width = 180.dp, height = 40.dp)
         )
      }
   }
}

