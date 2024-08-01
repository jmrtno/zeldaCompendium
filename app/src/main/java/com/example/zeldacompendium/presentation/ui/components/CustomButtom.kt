package com.example.zeldacompendium.presentation.ui.components


 import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
 import androidx.compose.foundation.layout.PaddingValues
 import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontStyle
 import androidx.compose.ui.text.style.TextAlign
 import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
   text: String,
   modifier: Modifier,
   onClick: () -> Unit,
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

   val color = Color(0xFF63FCFC)

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
      modifier = modifier
         .padding(12.dp)
         .background(Color(0xFFC4FFFF))
   ) {
      Button(
         onClick = { onClick() },
         colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
         interactionSource = NoRippleInteractionSource(),
         contentPadding = PaddingValues(horizontal = 3.dp),
         modifier = Modifier
            .fillMaxSize() // Asegura que el borde neon no quede cubierto por el Button
            .background(Color(0xFF121210), shape = CutCornerShape(20))
      ) {
         Text(
            text = text,
            color = Color(0xFFFFFEF2),
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
         )
      }
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
                  radiusX = 0.dp.toPx(),
                  5.dp.toPx(),
                  paint = paint
               )

               drawRoundRect(
                  Color(0xFFC4FFFF),
                  cornerRadius = CornerRadius(0f,0f),
                  style = Stroke(width = 1.dp.toPx())
               )
            }
         }
      }
   }
}

@Preview
@Composable
fun NeonSamplePreview() {
   CustomButton(
      onClick = {},
      text = "Button",
      modifier = Modifier.size(250.dp, 80.dp)
   )
}
