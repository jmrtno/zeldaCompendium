package com.example.zeldacompendium.presentation.ui.lists.breath.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zeldacompendium.presentation.ui.components.SearchBar
import com.example.zeldacompendium.presentation.ui.components.categoryselector.CategorySelector

@Composable
fun BottomBarSection(
   isError: String,
   onSearch: (String) -> Unit,
   onCategorySelected: (Int) -> Unit
) {
   if (isError.isEmpty()) {
      Column(
         modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
      ) {
         SearchBar(
            onSearch = onSearch
         )
         CategorySelector { newSelectedIndex ->
            onCategorySelected(newSelectedIndex)
         }
      }
   }
}