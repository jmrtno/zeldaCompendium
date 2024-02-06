package com.example.zeldacompendium.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.SegmentedControl
import com.example.zeldacompendium.presentation.ui.tears.CompendiumTearsViewModel

@Composable
fun CategorySelector(onItemSelected: (Int) -> Unit){
   Column{
      var selectedIndex by remember { mutableStateOf(0) }
      val items = listOf(
         R.drawable.creatures,
         R.drawable.monsters,
         R.drawable.equipment,
         R.drawable.materials,
         R.drawable.treasures
      )

      val itemsSelected = listOf(
         R.drawable.creatures_hint,
         R.drawable.monsters_hint,
         R.drawable.equipment_hint,
         R.drawable.materials_hint,
         R.drawable.treasures_hint
      )

      SearchBar(modifier = Modifier.padding(top = 15.dp))

      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
      ) {
         SegmentedControl(
            items = items,
            itemsSelected = itemsSelected,
            defaultSelectedItemIndex = 0
         ) {
            selectedIndex = it
            onItemSelected(it)
         }
      }
   }
}