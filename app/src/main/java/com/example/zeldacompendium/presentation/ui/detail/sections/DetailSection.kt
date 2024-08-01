package com.example.zeldacompendium.presentation.ui.detail.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.presentation.ui.components.RetrySection

@Composable
fun DetailSection(
   gameId: Int,
   itemId: Int,
   onDismiss: () -> Unit,
   viewModel: DetailViewModel = hiltViewModel()
) {
   val itemInfo = produceState<Resource<ItemDetailModel>>(initialValue = Resource.Loading()) {
      value = viewModel.getItemInfo(itemId, gameId)
   }.value

   Box(
      modifier = Modifier
         .fillMaxSize()
   ) {
      DetailStateWrapper(
         itemInfo = itemInfo,
         gameId = gameId,
         onDismiss = onDismiss,
         modifier = Modifier
            .size(100.dp)
            .align(Alignment.Center)
            .padding(
               top = 30.dp,
               start = 30.dp,
               end = 30.dp,
               bottom = 60.dp
            )
      )
   }
}

@Composable
fun DetailStateWrapper(
   itemInfo: Resource<ItemDetailModel>,
   gameId: Int,
   onDismiss: () -> Unit,
   modifier: Modifier = Modifier
) {
   when (itemInfo) {
      is Resource.Success -> {
         InfoCategorySection(
            itemInfo = itemInfo.data!!, gameId = gameId
         )
      }

      is Resource.Error -> {
         RetrySection(
            error = itemInfo.message!!,
            buttonTittle = "Exit"
         ) {
            onDismiss()
         }
      }

      is Resource.Loading -> {
         CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
         )
      }
   }
}