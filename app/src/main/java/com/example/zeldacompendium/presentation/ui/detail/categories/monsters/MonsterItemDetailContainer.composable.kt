@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.monsters

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
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.DropsPage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages.LocationPage

@Composable
fun MonsterItemDetailContainer(
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