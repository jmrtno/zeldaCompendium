package com.example.zeldacompendium.presentation.ui.breath

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
import androidx.compose.runtime.State
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.presentation.ui.navigation.AppNavigator
import com.example.zeldacompendium.presentation.ui.navigation.Destination

@HiltViewModel
class CompendiumBreathViewModel @Inject constructor(
   private val repository: CompendiumRepository,
   private val appNavigator: AppNavigator
): ViewModel() {

   private val _compendiumList = mutableStateOf<List<CompendiumListEntry>>(listOf())
   val compendiumList: State<List<CompendiumListEntry>> = _compendiumList
   var loadError = mutableStateOf("")
   var isLoading = mutableStateOf(false)

   fun loadCompendium() {
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
               loadError.value = ""
               isLoading.value = false
               // Convertir la lista a un conjunto para eliminar duplicados
               val uniqueSet = compendiumEntries.toSet()

               // Asignar la lista única al _compendiumList
               _compendiumList.value = uniqueSet.toList()
            }

            is Resource.Error -> {
               loadError.value = data.message!!
               isLoading.value = false
            }

            is Resource.Loading -> TODO()

         }
      }
   }

   fun onBackButtonClicked() {
      appNavigator.tryNavigateBack()
   }
   fun onItemRowClicked(name: String, category: String) {
      appNavigator.tryNavigateTo(
         Destination.ItemDetailsScreen(
            name = name,
            category = category
         )
      )
   }
}