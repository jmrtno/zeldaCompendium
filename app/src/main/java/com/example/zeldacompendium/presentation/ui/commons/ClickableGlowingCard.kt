package com.example.zeldacompendium.presentation.ui.commons

import android.graphics.Paint
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GlowingCard(
   glowingColor: Color,
   modifier: Modifier = Modifier,
   //imageDrawableResId: Int = R.drawable.button_bg,
   containerColor: Color = Color(0XFF0C0D09),
   cornersRadius: Dp = 0.dp,
   glowingRadius: Dp = 10.dp,
   xShifting: Dp = 0.dp,
   yShifting: Dp = 0.dp,
   content: @Composable BoxScope.() -> Unit
) {
   for (i in 1..5) {
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
                  color = containerColor.toArgb()
                  isAntiAlias = true
                  setShadowLayer(
                     glowingRadius.toPx(),
                     xShifting.toPx(),
                     yShifting.toPx(),
                     glowingColor.copy(alpha = 0.2f * i).toArgb()
                  )
               }
            )
         }
      }
      ) {
         Box(
            modifier = Modifier
               .fillMaxSize()
               .clip(RoundedCornerShape(cornersRadius))
               .border(3.dp, Color(0xFF946D48), RoundedCornerShape(10.dp))
         ) {
            // para imagen de fondo añadir aqui
            /*
            Image(
               modifier = Modifier
                  .fillMaxSize()
                  .border(3.dp, Color(0xFF946D48), shape = RoundedCornerShape(cornersRadius)),
               painter = painterResource(id = imageDrawableResId),
               contentDescription = null,
               contentScale = ContentScale.Crop
            )
            */
            content()
         }
      }
   }
}