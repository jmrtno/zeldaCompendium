package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun HorizontalPagerIndicator(
   pageCount: Int,
   currentPage: Int,
   targetPage: Int,
   currentPageOffsetFraction: Float,
   modifier: Modifier = Modifier,
   indicatorColor: Color = Color(0xFF19FFFF),
   unselectedIndicatorSize: Dp = 8.dp,
   selectedIndicatorSize: Dp = 10.dp,
   indicatorPadding: Dp = 2.dp
) {
   Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier
         .wrapContentSize()
         .height(selectedIndicatorSize + indicatorPadding * 2)
   ) {

      // draw an indicator for each page
      repeat(pageCount) { page ->
         // calculate color and size of the indicator
         val (color, size) =
            if (currentPage == page || targetPage == page) {
               // calculate page offset
               val pageOffset =
                  ((currentPage - page) + currentPageOffsetFraction).absoluteValue
               // calculate offset percentage between 0.0 and 1.0
               val offsetPercentage = 1f - pageOffset.coerceIn(0f, 1f)

               val size =
                  unselectedIndicatorSize + ((selectedIndicatorSize - unselectedIndicatorSize) * offsetPercentage)

               indicatorColor.copy(
                  alpha = offsetPercentage
               ) to size
            } else {
               indicatorColor.copy(alpha = 0.1f) to unselectedIndicatorSize
            }

         // draw indicator
         Box(
            modifier = Modifier
               .padding(
                  // apply horizontal padding, so that each indicator is same width
                  horizontal = ((selectedIndicatorSize + indicatorPadding * 2) - size) / 2,
                  vertical = size / 10
               )
               .clip(CircleShape)
               .background(color)
               .size(size)
         )
      }
   }
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalPagerIndicator() {
   HorizontalPagerIndicator(
      pageCount = 5,
      currentPage = 2,
      targetPage = 3,
      currentPageOffsetFraction = 0.5f
   )
}