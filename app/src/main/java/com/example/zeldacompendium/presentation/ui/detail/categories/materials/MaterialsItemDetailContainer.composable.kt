@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.materials

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.NavigationService
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.HorizontalPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.CookingEffectPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.FusedPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.HealingPage
import com.example.zeldacompendium.presentation.ui.commons.HorizontalPages.pages.LocationPage
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.CookingEffectImageProvider

@Composable
fun MaterialsItemDetailContainer(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { if (gameId == 1) 3 else 4 })
   HorizontalPager(
      modifier = Modifier.fillMaxHeight(),
      state = pagerState,
      pageSpacing = 20.dp,
      contentPadding = PaddingValues(
         horizontal = 48.dp,
         vertical = 12.dp
      ),
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




