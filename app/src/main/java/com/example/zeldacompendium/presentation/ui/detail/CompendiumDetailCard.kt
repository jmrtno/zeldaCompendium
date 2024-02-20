package com.example.zeldacompendium.presentation.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.data.utils.Resource

@Composable
fun CompendiumDetailCard(
   id: Int,
   viewModel: CompendiumDetailViewModel = hiltViewModel()
) {
   //val itemInfo by remember {viewModel.compendiumDetail}
   val itemInfo = produceState<Resource<Data>>(initialValue = Resource.Loading()) {
      value = viewModel.getItemInfo(id)
   }.value
   ElevatedCard(
      elevation = CardDefaults.cardElevation(
         defaultElevation = 6.dp
      ),
      modifier = Modifier
         .fillMaxWidth()
   ) {
      ItemDetailStateWrapper(
         itemInfo = itemInfo,
         loadingModifier = Modifier
            .size(100.dp)
            .align(Alignment.CenterHorizontally)
            .padding(
               top = 16.dp,
               start = 16.dp,
               end = 16.dp,
               bottom = 16.dp
            )
      )
   }
}

@Composable
fun ItemDetailStateWrapper(
   itemInfo: Resource<Data>,
   loadingModifier: Modifier = Modifier
){
   when(itemInfo){
      is Resource.Success -> {
         ItemDetailInfo(
            itemInfo = itemInfo.data!!
         )
      }
      is Resource.Error -> {
         Text(
            text = itemInfo.message!!,
            color = Color.Red,
         )
      }
      is Resource.Loading -> {
         CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = loadingModifier
         )
      }
   }
}

@Composable
fun ItemDetailInfo(
   itemInfo: Data
){
   Text(text = itemInfo.name ?: "Nombre no disponible")
}

