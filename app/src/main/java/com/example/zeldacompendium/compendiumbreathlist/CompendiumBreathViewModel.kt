package com.example.zeldacompendium.compendiumbreathlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.repository.CompendiumRepository
import com.example.zeldacompendium.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CompendiumBreathViewModel @Inject constructor(
   private val repository: CompendiumRepository
): ViewModel() {

   var compendiumList = mutableStateOf<List<CompendiumListEntry>>(listOf())
   var loadError = mutableStateOf("")
   var isLoading = mutableStateOf(false)

   init {
      loadCompendium()
   }

   fun loadCompendium(){
      viewModelScope.launch {
         isLoading.value = true
         when(val data = repository.getBreathAllEntries()){
            is Resource.Success -> {
               Timber.tag("loadCompendium").d("called loadCompendium()")
               val compendiumEntries = data.data!!.data.mapIndexed { index, entry ->
                  val entryId = entry.id
                  val url = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/${entryId}/image"
                  CompendiumListEntry(entry.name.replaceFirstChar {
                     if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                     ) else it.toString()
                  }, entry.category, url, entry.id)
               }
               loadError.value = ""
               isLoading.value = false
               compendiumList.value += compendiumEntries
            }
            is Resource.Error -> {
               loadError.value = data.message!!
               isLoading.value = false
            }

            is Resource.Loading -> TODO()

         }
      }
   }

   suspend fun getCategoryBreath(categoryName: String): Resource<Data> {
      return repository.getCategoriesBreath(categoryName)
   }
}