package com.example.zeldacompendium.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.domain.repository.CompendiumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
   private val repository: CompendiumRepository
) : ViewModel() {

   suspend fun getItemInfo(itemId: Int, game: Int): Resource<ItemDetailModel> {
      return repository.getItemInfo(itemId, game)
   }
}