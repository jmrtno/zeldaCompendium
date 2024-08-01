package com.example.zeldacompendium.presentation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GlowingCard(
   content: @Composable BoxScope.() -> Unit
) {
   val paint = remember {
      Paint().apply {
         style = PaintingStyle.Stroke
         strokeWidth = 20f
      }
   }

   val frameworkPaint = remember {
      paint.asFrameworkPaint()
   }

   val color = Color(0xFF005CBA)

   val transparent = color
      .copy(alpha = 0f)
      .toArgb()

   frameworkPaint.color = transparent

   frameworkPaint.setShadowLayer(
      10f,
      0f,
      0f,
      color
         .copy(alpha = .5f)
         .toArgb()
   )
   Box(
      modifier = Modifier
         .height(75.dp)
         .background(Color(0XFF0C0D09), RoundedCornerShape(10.dp))
   ) {
      content()
      Canvas(modifier = Modifier
         .fillMaxSize()
      ) {
         inset {
            this.drawIntoCanvas {
               it.drawRoundRect(
                  left = 0f,
                  top = 0f,
                  right = size.width,
                  bottom = size.height,
                  radiusX = 10.dp.toPx(),
                  5.dp.toPx(),
                  paint = paint
               )

               drawRoundRect(
                  Color(0xFF63FCFC),
                  cornerRadius = CornerRadius(10f,10f),
                  style = Stroke(width = 1.dp.toPx())
               )
            }
         }
      }
   }
}


@Preview
@Composable
fun GlowingCardPreview() {
   GlowingCard(
   ) {
      // Add content here for preview
   }
}