package com.example.zeldacompendium.domain

import com.example.zeldacompendium.data.models.CompendiumListEntry
class CompendiumFilterImpl : CompendiumFilter {
   override fun filterCompendiumList(compendiumList: List<CompendiumListEntry>, selectedIndex: Int): List<CompendiumListEntry> {
      return when (selectedIndex) {
         0 -> compendiumList.filter { it.category == "creatures" }
         1 -> compendiumList.filter { it.category == "monsters" }
         2 -> compendiumList.filter { it.category == "equipment" }
         3 -> compendiumList.filter { it.category == "materials" }
         4 -> compendiumList.filter { it.category == "treasure" }
         else -> emptyList()
      }
   }
}