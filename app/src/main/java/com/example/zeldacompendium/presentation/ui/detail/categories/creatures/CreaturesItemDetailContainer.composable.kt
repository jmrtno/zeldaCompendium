@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.creatures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.CookingEffectPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.DropsPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.HealingPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.LocationPage

@Composable
fun CreaturesItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { 3 })
   HorizontalPager(
      modifier = Modifier.fillMaxHeight(),
      state = pagerState,
      pageSpacing = 20.dp,
      contentPadding = PaddingValues(
         horizontal = 48.dp,
         vertical = 12.dp
      ),
   ) { page ->
         if (!itemInfo.data.edible) {
            when (page) {
               0 -> DropsPage(itemInfo)
               1 -> LocationPage(itemInfo, gameId)
            }
         } else {
            when (page) {
               0 -> HealingPage(itemInfo)
               1 -> CookingEffectPage(itemInfo)
               2 -> LocationPage(itemInfo, gameId)
            }
         }
      }
}
