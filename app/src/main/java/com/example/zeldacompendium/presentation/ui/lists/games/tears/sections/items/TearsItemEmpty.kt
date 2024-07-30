package com.example.zeldacompendium.presentation.ui.lists.games.tears.sections.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.presentation.ui.components.GlowingCard

@Composable
fun TearsItemEmpty(
   modifier: Modifier = Modifier
) {
   Box(modifier = modifier
      .fillMaxWidth()
      .padding(15.dp)
   ) {
      GlowingCard { }
      Row(
         modifier = modifier
            .height(70.dp)
            .padding(horizontal = 15.dp),
         verticalAlignment = Alignment.CenterVertically,
      ) {
         Text(
            modifier = modifier.weight(1.0f),
            maxLines = 1,
            text = "Item does not exist",
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            color = Color.LightGray,
            overflow = TextOverflow.Ellipsis
         )
         Text(
            modifier = modifier.weight(0.4f),
            text = "#",
            textAlign = TextAlign.End,
            maxLines = 1,
            fontSize = 25.sp,
            color = Color.White.copy(alpha = 0.4f)
         )
      }
   }
}
@Preview
@Composable
fun CompendiumItemBreathEmptyPreview() {
   TearsItemEmpty()
}