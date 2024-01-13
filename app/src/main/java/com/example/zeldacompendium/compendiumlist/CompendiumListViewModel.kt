package com.example.zeldacompendium.compendiumlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.repository.CompendiumRepository
import com.example.zeldacompendium.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CompendiumListViewModel @Inject constructor(
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
            when(val data = repository.getAllEntries()){
                is Resource.Success -> {
                    Timber.tag("loadCompendium").d("called loadCompendium()")
                    val compendiumEntries = data.data!!.data.mapIndexed { index, entry ->
                        CompendiumListEntry(entry.name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.ROOT
                            ) else it.toString()
                        }, entry.category, entry.id)
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
}