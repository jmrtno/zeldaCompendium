@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.presentation.ui.lists.tears.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.components.GlowingCard
import com.example.zeldacompendium.presentation.ui.detail.sections.ItemDetailModalContainer

@Composable
fun CompendiumItemTears(
   entry: CompendiumListEntry,
   modifier: Modifier = Modifier,
) {
   var showBottomSheet by remember { mutableStateOf(false) }

   Box(modifier = modifier
      .fillMaxWidth()
      .padding(15.dp)
      .clickable {
         showBottomSheet = true
      }) {
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
            text = entry.compendiumName,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            color = Color.LightGray,
            overflow = TextOverflow.Ellipsis
         )
         Text(
            modifier = modifier.weight(0.4f),
            text = "#${entry.id}",
            textAlign = TextAlign.End,
            maxLines = 1,
            fontSize = 25.sp,
            color = Color.White.copy(alpha = 0.4f)
         )

         ItemDetailModalContainer(
            gameId = 2,
            entry = entry,
            showBottomSheet = showBottomSheet,
            onDismiss = { showBottomSheet = false }
         )
      }
   }
}