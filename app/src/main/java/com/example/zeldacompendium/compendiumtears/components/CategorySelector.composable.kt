package com.example.zeldacompendium.compendiumtears.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.R
import com.example.zeldacompendium.compendiumtears.CompendiumTearsViewModel

@Composable
fun CategorySelector(
   viewModel: CompendiumTearsViewModel = hiltViewModel(),
   paddingValues: PaddingValues
) {
   LaunchedEffect(key1 = true) {
      viewModel.loadCompendium()
   }
   Column(
      modifier = Modifier.padding(paddingValues)
   ){

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
      var selectedIndex by remember { mutableStateOf(0) }
      Row(
         modifier = Modifier
            .fillMaxWidth(),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
      ) {
         SegmentedControl(
            items = items,
            itemsSelected = itemsSelected,
            defaultSelectedItemIndex = 0
         ) {
            selectedIndex = it
         }
      }
      val filteredList = when (selectedIndex) {
         0 -> viewModel.compendiumList.value.filter { it.category == "creatures" }
         1 -> viewModel.compendiumList.value.filter { it.category == "monsters" }
         2 -> viewModel.compendiumList.value.filter { it.category == "equipment" }
         3 -> viewModel.compendiumList.value.filter { it.category == "materials" }
         4 -> viewModel.compendiumList.value.filter { it.category == "treasure" }
         else -> emptyList()
      }

      CompendiumList(compendiumList = filteredList)
   }
}