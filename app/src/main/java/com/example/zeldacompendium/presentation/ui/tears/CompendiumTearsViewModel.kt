package com.example.zeldacompendium.presentation.ui.tears

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
class CompendiumTearsViewModel @Inject constructor(
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
            when(val data = repository.getTearsAllEntries()){
                is Resource.Success -> {
                    Timber.tag("loadCompendium").d("called loadCompendium()")
                    val compendiumEntries = data.data!!.data.mapIndexed { index, entry ->
                        CompendiumListEntry(entry.name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.ROOT
                            ) else it.toString()
                        }, entry.category, entry.image, entry.id)
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