package com.example.zeldacompendium.presentation.ui.commons

import com.example.zeldacompendium.R

class CategorySelectorHelper {
   companion object {
      val items = listOf(
         R.drawable.creatures,
         R.drawable.monsters,
         R.drawable.materials,
         R.drawable.equipment,
         R.drawable.treasures
      )

      val itemsSelected = listOf(
         R.drawable.creatures_hint,
         R.drawable.monsters_hint,
         R.drawable.materials_hint,
         R.drawable.equipment_hint,
         R.drawable.treasures_hint
      )
   }
}