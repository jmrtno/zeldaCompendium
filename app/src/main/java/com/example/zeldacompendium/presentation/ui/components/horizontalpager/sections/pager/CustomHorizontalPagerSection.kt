@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.indicator.HorizontalPagerIndicator


@Composable
fun CustomHorizontalPager(
   pagerState: PagerState,
   pageContent: @Composable (page: Int) -> Unit
) {
   Column(
      modifier = Modifier
         .fillMaxWidth()
         .padding(bottom = 20.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
   ) {
      HorizontalPager(
         modifier = Modifier.weight(1f),
         state = pagerState,
         pageSpacing = 20.dp,
         contentPadding = PaddingValues(
            start = 48.dp,
            end = 48.dp
         ),
      ) { page ->
         pageContent(page)
      }
      HorizontalPagerIndicator(
         modifier = Modifier.height(25.dp),
         pageCount = pagerState.pageCount,
         currentPage = pagerState.currentPage,
         targetPage = pagerState.targetPage,
         currentPageOffsetFraction = pagerState.currentPageOffsetFraction
      )
   }
}