@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.treasures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pager.CustomHorizontalPager
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.DropsPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.LocationPage

@Composable
fun TreasureItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { 2 })
   CustomHorizontalPager(
      pagerState = pagerState,
   ) { page ->
      when (page) {
         0 -> DropsPage(itemInfo)
         1 -> LocationPage(itemInfo, gameId)
      }
   }
}