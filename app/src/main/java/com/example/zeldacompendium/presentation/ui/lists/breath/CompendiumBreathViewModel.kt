package com.example.zeldacompendium.presentation.ui.lists.breath

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.domain.repository.CompendiumRepository
import com.example.zeldacompendium.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CompendiumBreathViewModel @Inject constructor(
   private val repository: CompendiumRepository,
): ViewModel() {

   var compendiumList = mutableStateOf<List<CompendiumListEntry>>(listOf())
   // Utilizar un conjunto para realizar un seguimiento de elementos únicos
   private val uniqueEntriesSet = mutableSetOf<CompendiumListEntry>()
   var loadError = mutableStateOf("")
   var isLoading = mutableStateOf(false)

   init {
      loadBreathList()
   }
   fun loadBreathList() {
      viewModelScope.launch {
         isLoading.value = true
         when (val data = repository.getBreathAllEntries()) {
            is Resource.Success -> {
               Timber.tag("loadCompendium").d("called loadCompendium()")
               val compendiumEntries = data.data!!.data.mapIndexed { index, entry ->
                  val entryId = entry.id
                  val url =
                     "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/${entryId}/image"
                  CompendiumListEntry(entry.name.replaceFirstChar {
                     if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                     ) else it.toString()
                  }, entry.category, url, entry.id)
               }

               // Filtrar elementos duplicados antes de agregar a la lista
               val uniqueNewEntries = compendiumEntries.filter { uniqueEntriesSet.add(it) }

               loadError.value = ""
               isLoading.value = false
               compendiumList.value += uniqueNewEntries
            }

            is Resource.Error -> {
               loadError.value = data.message!!
               isLoading.value = false
            }

            is Resource.Loading -> TODO()

         }
      }
   }
}