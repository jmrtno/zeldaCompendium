package com.example.zeldacompendium.presentation.ui.commons

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R

@Composable
fun ClickableGlowingCard(
   glowingColor: Color,
   modifier: Modifier = Modifier,
   imageDrawableResId: Int = R.drawable.button_bg,
   cornersRadius: Dp = 0.dp,
   glowingRadius: Dp = 15.dp,
   xShifting: Dp = 0.dp,
   yShifting: Dp = 0.dp,
   onClick: () -> Unit = {},
   content: @Composable BoxScope.() -> Unit
) {
   Box(modifier = modifier.drawBehind {
      val canvasSize = size
      drawContext.canvas.nativeCanvas.apply {
         drawRoundRect(0f, // Left
            0f, // Top
            canvasSize.width, // Right
            canvasSize.height, // Bottom
            cornersRadius.toPx(), // Radius X
            cornersRadius.toPx(), // Radius Y
            Paint().apply {
               isAntiAlias = true
               setShadowLayer(
                  glowingRadius.toPx(),
                  xShifting.toPx(),
                  yShifting.toPx(),
                  glowingColor.copy(alpha = 1f).toArgb()
               )
            }
         )
      }
   }
   ) {
      Box(
         modifier = Modifier
            .clip(RoundedCornerShape(cornersRadius))
            .clickable { onClick() }
      ) {
         Image(
            modifier = Modifier
               .fillMaxSize()
               .border(3.dp, Color(0xFF946D48), shape = RoundedCornerShape(cornersRadius)),
            painter = painterResource(id = imageDrawableResId),
            contentDescription = null,
            contentScale = ContentScale.Crop
         )
         content()
      }
   }
}