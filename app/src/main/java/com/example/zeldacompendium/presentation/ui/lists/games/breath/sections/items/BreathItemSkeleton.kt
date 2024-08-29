package com.example.zeldacompendium.presentation.ui.lists.games.breath.sections.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.zeldacompendium.presentation.ui.components.GlowingCard

@Composable
fun BreathItemSkeleton(
   modifier: Modifier = Modifier
) {
   Box(modifier = modifier
      .padding(top = 30.dp)
   ) {
      Column(
         modifier = modifier
            .zIndex(1f)
            .padding(horizontal = 40.dp),
      ) {
         SkeletonImage(modifier = modifier)
         SkeletonText(modifier = modifier)
      }
      SkeletonItemBg(modifier = modifier)
   }
}

@Composable
fun SkeletonImage(modifier: Modifier = Modifier) {
   Box(
      modifier = modifier.offset(y = (-22).dp),
      contentAlignment = Alignment.Center
   ) {
      Box(
         modifier = modifier
            .size(50.dp)
            .background(Color.Gray.copy(alpha = 0.3f))
      )
      Box(
         modifier = modifier.size(63.dp),
         contentAlignment = Alignment.Center
      ) {
         Box(
            modifier = modifier
               .fillMaxSize()
               .border(1.dp, Color.Gray.copy(alpha = 0.3f))
         )
      }
   }
}

@Composable
fun SkeletonText(modifier: Modifier = Modifier) {
   Box(
      modifier = modifier
         .offset(y = (-19).dp)
         .height(20.dp)
         .fillMaxWidth(0.6f)
         .background(Color.Gray.copy(alpha = 0.3f))
   )
}

@Composable
fun SkeletonItemBg(modifier: Modifier = Modifier) {
   Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(75.dp)
        .padding(horizontal = 15.dp)
        .background(Color(0XFF0C0D09), RoundedCornerShape(10.dp))
   ) {
      Row(
         modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(end = 15.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.End
      ) {
         Box(
            modifier = modifier
               .height(25.dp)
               .width(30.dp)
               .background(Color.Gray.copy(alpha = 0.3f))
         )
      }
   }
   }


@Preview
@Composable
fun BreathItemSkeletonPreview() {
   BreathItemSkeleton()
}
