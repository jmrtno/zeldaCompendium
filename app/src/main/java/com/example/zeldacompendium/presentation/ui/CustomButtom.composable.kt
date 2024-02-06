package com.example.zeldacompendium.presentation.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R

@Composable
fun ImageButton(
   onClick: () -> Unit,
   @DrawableRes backgroundDrawableId: Int,
   modifier: Modifier = Modifier,
   shape: Shape = RoundedCornerShape(5.dp),
   border: BorderStroke? = null,
   contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
   content: @Composable RowScope.() -> Unit
) {
   Button(
      modifier = modifier,
      onClick = onClick,
      contentPadding = PaddingValues(0.dp),
      shape = shape,
      border = border,
   ) {
      Box(
         contentAlignment = Alignment.Center,
      ) {
         Image(
            modifier = Modifier.matchParentSize(),
            painter = painterResource(backgroundDrawableId),
            contentDescription = "",
            contentScale = ContentScale.None,
         )
         Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(contentPadding),
            content = content,
         )
      }
   }
}
@Preview
@Composable
fun ImageButtonPreview(
   contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) {
   ImageButton(
      onClick = { /* Acción al hacer clic */ },
      backgroundDrawableId = R.drawable.button_bg,
      modifier = Modifier
         .padding(16.dp),
      shape = RoundedCornerShape(5.dp),
      border = BorderStroke(3.dp, Color(0xFF946D48)),
      contentPadding = contentPadding,
   ) {
      Text(text = "TOTK", color = Color(0xFF19ffff))
   }
}