@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.sections.categories.materials

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pager.CustomHorizontalPager
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.CookingEffectPage
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.FusedPage
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.HealingPage
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pages.LocationPage

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




