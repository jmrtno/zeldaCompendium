@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.creatures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pager.CustomHorizontalPager
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.CookingEffectPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.DropsPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.HealingPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.LocationPage

@Composable
fun CreaturesItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { if (itemInfo.data.edible) 3 else 2 })
   CustomHorizontalPager(
      pagerState = pagerState
   ) { page ->
         if (itemInfo.data.edible) {
            when (page) {
               0 -> HealingPage(itemInfo)
               1 -> CookingEffectPage(itemInfo)
               2 -> LocationPage(itemInfo, gameId)
            }
         } else {
            when (page) {
               0 -> DropsPage(itemInfo)
               1 -> LocationPage(itemInfo, gameId)
            }
         }
      }
}
