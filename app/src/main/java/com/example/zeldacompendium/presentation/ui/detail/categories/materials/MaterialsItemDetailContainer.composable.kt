@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.materials

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.CustomHorizontalPager
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.CookingEffectPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.FusedPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.HealingPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.LocationPage

@Composable
fun MaterialsItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { if (gameId == 1) 3 else 4 })
   CustomHorizontalPager(
      pagerState = pagerState,
   ) { page ->
      if (gameId == 1) {
         when (page) {
            0 -> HealingPage(itemInfo)
            1 -> CookingEffectPage(itemInfo)
            2 -> LocationPage(itemInfo, gameId)
         }
      } else {
         when (page) {
            0 -> HealingPage(itemInfo)
            1 -> CookingEffectPage(itemInfo)
            2 -> LocationPage(itemInfo, gameId)
            3 -> FusedPage(itemInfo)
         }
      }
   }
}




