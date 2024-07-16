@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.monsters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.NavigationService
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.HorizontalPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.DropsPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.LocationPage
import java.util.Locale

@Composable
fun MonsterItemDetailContainer(
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
         when (page) {
            0 -> DropsPage(itemInfo)
            1 -> LocationPage(itemInfo, gameId)
         }
      }
}