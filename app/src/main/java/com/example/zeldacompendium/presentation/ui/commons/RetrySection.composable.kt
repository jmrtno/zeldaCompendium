package com.example.zeldacompendium.presentation.ui.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R

@Composable
fun RetrySection(
   error: String,
   bottomTittle: String,
   onRetry: () -> Unit
) {
   Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(30.dp),
      modifier = Modifier.padding(top = 12.dp)
   ) {
      Image(
         painter = painterResource(id = R.drawable.game_over),
         contentDescription = "game over icon"
      )
      Text(
         text = error,
         textAlign = TextAlign.Center,
         color = Color(0xFFE2DED3),
         fontSize = 18.sp,
         modifier = Modifier.padding(horizontal = 24.dp)
      )
      ImageButton(
         onClick = { onRetry() },
      ) {
         Text(
            text = bottomTittle,
            color = Color(0xFF19FFFF)
         )
      }
   }
}

@Preview
@Composable
fun RetrySectionPreview() {
   RetrySection(
      bottomTittle = "Button",
      error = "Something went wrong. Please try again.",
      onRetry = { /* Handle retry action here */ }
   )
}