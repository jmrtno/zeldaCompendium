package com.example.zeldacompendium.presentation.ui.lists.games.tears

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
class TearsViewModel @Inject constructor(
    private val repository: CompendiumRepository,
): ViewModel() {

    var compendiumList = mutableStateOf<List<CompendiumListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    private var originalCompendiumList = listOf<CompendiumListEntry>()

    init {
       loadCompendium()
    }

    fun loadCompendium(){
        viewModelScope.launch {
            isLoading.value = true
            when(val data = repository.getTearsAllEntries()) {
                is Resource.Success -> {
                    Timber.tag("loadCompendium").d("called loadCompendium()")
                    val compendiumEntries = data.data!!.data.mapIndexed { index, entry ->
                        CompendiumListEntry(
                            entry.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                            }, entry.category, entry.image, entry.id)
                    }.sortedBy { it.id }
                    loadError.value = ""
                    isLoading.value = false
                    originalCompendiumList = compendiumEntries
                    compendiumList.value = originalCompendiumList
                }
                is Resource.Error -> {
                    loadError.value = data.message!!
                    isLoading.value = false
                }

                is Resource.Loading -> TODO()

            }
        }
    }

    fun searchCompendium(query: String) {
        val filteredList = if (query.isBlank()) {
            originalCompendiumList
        } else {
            originalCompendiumList.filter {
                it.compendiumName.contains(query, ignoreCase = true)
            }
        }
        compendiumList.value = filteredList
    }
}