package com.example.zeldacompendium.presentation.ui.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.R

@Composable
fun CategorySelector(onItemSelected: (Int) -> Unit){
   Column{
      var selectedIndex by remember { mutableStateOf(0) }

      SearchBar(modifier = Modifier.padding(top = 15.dp))

      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp, top = 15.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
      ) {
         SegmentedControl(
            items = CategorySelectorHelper.items,
            itemsSelected = CategorySelectorHelper.itemsSelected,
            defaultSelectedItemIndex = 0
         ) {
            selectedIndex = it
            onItemSelected(it)
         }
      }
   }
}