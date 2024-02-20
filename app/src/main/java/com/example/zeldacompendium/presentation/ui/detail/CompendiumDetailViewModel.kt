package com.example.zeldacompendium.presentation.ui.detail

import androidx.lifecycle.ViewModel
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.domain.repository.CompendiumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompendiumDetailViewModel @Inject constructor(
   private val repository: CompendiumRepository,
   //private val itemId: Int
) : ViewModel() {

   /*
   // TODO - Add private and public mutableState
   private val _compendiumDetail = mutableStateOf<Data?>(null)
   val compendiumDetail: State<Data?> = _compendiumDetail

   private val _detailState = MutableStateFlow<Data?>(null)
   val detailState: StateFlow<Data?> = _detailState.asStateFlow()

   var loadError = mutableStateOf("")
   var isLoading = mutableStateOf(false)

   init {
      // TODO - Make call to service
      viewModelScope.launch {
         getItemInfo(itemId)
      }
   }

    */
   suspend fun getItemInfo(id: Int): Resource<Data> {
      return repository.getItemInfo(id)
   }
}