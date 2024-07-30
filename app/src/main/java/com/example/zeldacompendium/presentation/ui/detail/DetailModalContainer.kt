@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.presentation.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.detail.sections.DetailSection

@Composable
fun DetailModalContainer(
   gameId: Int,
   entry: CompendiumListEntry,
   showBottomSheet: Boolean,
   sheetState: SheetState = rememberModalBottomSheetState(
      skipPartiallyExpanded = true
   ),
   windowInsets: WindowInsets = WindowInsets.displayCutout,
   onDismiss: () -> Unit
){
   val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
   if (showBottomSheet) {
      ModalBottomSheet(
         onDismissRequest = { onDismiss() },
         containerColor = Color(0XFF141413),
         shape = RoundedCornerShape(20.dp),
         sheetState = sheetState,
         windowInsets = windowInsets
      ) {
         Column(modifier = Modifier.padding(bottom = bottomPadding)) {
            DetailSection(
               itemId = entry.id,
               gameId = gameId,
               onDismiss = onDismiss
            )
         }
      }
   }
}