package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.HorizontalPage
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.creatures.CookingEffectImageProvider

@Composable
fun CookingEffectPage(
   itemInfo: ItemDetailModel
){
   val imageCookingEffect = CookingEffectImageProvider.getImageResource(itemInfo.data.cookingEffect)
   HorizontalPage(text = "Cooking Effect") {
      item {
         Box(modifier = Modifier.fillMaxWidth()) {
            Image(
               modifier = Modifier.fillMaxWidth(),
               painter = painterResource(id = imageCookingEffect),
               contentDescription = "cooking effect",
               contentScale = ContentScale.FillWidth,
            )
         }
      }
   }
}

