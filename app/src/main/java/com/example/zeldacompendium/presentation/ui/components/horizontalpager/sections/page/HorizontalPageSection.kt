package com.example.zeldacompendium.presentation.ui.components.horizontalpager.sections.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HorizontalPage(
   text: String,
   content: LazyListScope.() -> Unit
) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(
            Color(0XFF292825).copy(alpha = 0.5f),
            shape = RoundedCornerShape(15.dp))
         .border(
            width = 1.dp,
            color = Color.LightGray.copy(alpha = 0.5f),
            shape = RoundedCornerShape(15.dp)
         ),
   ) {
      LazyColumn(
         contentPadding = PaddingValues(11.dp)
      ) {
         item {
            Text(
               text = text,
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               fontSize = 20.sp,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
         }
         content()
      }
   }
}
