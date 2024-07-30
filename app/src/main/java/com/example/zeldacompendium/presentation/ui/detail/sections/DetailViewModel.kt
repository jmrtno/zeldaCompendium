package com.example.zeldacompendium.presentation.ui.detail.sections

import androidx.lifecycle.ViewModel
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.domain.repository.CompendiumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
   private val repository: CompendiumRepository
) : ViewModel() {

   suspend fun getItemInfo(itemId: Int, game: Int): Resource<ItemDetailModel> {
      return repository.getItemInfo(itemId, game)
   }
}