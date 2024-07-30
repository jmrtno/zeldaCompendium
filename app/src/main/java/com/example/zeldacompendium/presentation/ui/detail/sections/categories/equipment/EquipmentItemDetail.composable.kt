@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.sections.categories.equipment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pager.CustomHorizontalPager
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type.LocationPage
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page.type.PropertiesPage

@Composable
fun EquipmentItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { 2 })
   CustomHorizontalPager(
      pagerState = pagerState,
   ) { page ->
         when (page) {
            0 -> PropertiesPage(itemInfo, gameId)
            1 -> LocationPage(itemInfo, gameId)
         }
   }
}