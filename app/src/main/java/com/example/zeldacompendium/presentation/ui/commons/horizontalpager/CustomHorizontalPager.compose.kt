@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.commons.horizontalpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CustomHorizontalPager(
   pagerState: PagerState,
   pageContent: @Composable (page: Int) -> Unit
) {
   HorizontalPager(
      modifier = Modifier.fillMaxHeight(),
      state = pagerState,
      pageSpacing = 20.dp,
      contentPadding = PaddingValues(
         start = 48.dp,
         end = 48.dp,
         bottom = 22.dp
      ),
   ) { page ->
      pageContent(page)
   }
}