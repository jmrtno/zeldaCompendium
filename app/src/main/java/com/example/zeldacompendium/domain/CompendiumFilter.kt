package com.example.zeldacompendium.domain

import com.example.zeldacompendium.data.models.CompendiumListEntry

interface CompendiumFilter {
   fun filterCompendiumList(compendiumList: List<CompendiumListEntry>, selectedIndex: Int): List<CompendiumListEntry>
}