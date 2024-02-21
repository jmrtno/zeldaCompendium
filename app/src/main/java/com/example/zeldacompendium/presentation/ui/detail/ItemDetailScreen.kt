package com.example.zeldacompendium.presentation.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Resource
import java.util.Locale

@Composable
fun ItemDetailScreen(
   itemId: Int,
   navController: NavController,
   viewModel: ItemDetailViewModel = hiltViewModel()
) {

   val itemInfo = produceState<Resource<ItemDetailModel>>(initialValue = Resource.Loading()) {
      value = viewModel.getItemInfo(itemId)
   }.value

   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(bottom = 16.dp)
   ) {
      ItemDetailStateWrapper(
         itemInfo = itemInfo,
         modifier = Modifier
            .fillMaxSize()
            .padding(
               top = 16.dp,
               start = 16.dp,
               end = 16.dp,
               bottom = 16.dp
            )
            .shadow(10.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .align(Alignment.BottomCenter),
         loadingModifier = Modifier
            .size(100.dp)
            .align(Alignment.Center)
            .padding(
               top = 16.dp,
               start = 16.dp,
               end = 16.dp,
               bottom = 16.dp
            )
      )
      Box(
         contentAlignment = Alignment.TopCenter,
         modifier = Modifier
            .fillMaxSize()
      ) {
         if (itemInfo is Resource.Success) {


         }
      }
   }
}

@Composable
fun ItemDetailStateWrapper(
   itemInfo: Resource<ItemDetailModel>,
   modifier: Modifier = Modifier,
   loadingModifier: Modifier = Modifier
) {
   when (itemInfo) {
      is Resource.Success -> {
         ItemDetailSection(
            itemInfo = itemInfo.data!!,
            modifier = modifier
               .offset(y = (-20).dp)
         )
      }

      is Resource.Error -> {
         Text(
            text = itemInfo.message!!,
            color = Color.Red,
            modifier = modifier
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
fun ItemDetailSection(
   itemInfo: ItemDetailModel,
   modifier: Modifier = Modifier
) {
   val scrollState = rememberScrollState()
   Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = modifier
         .fillMaxSize()
         .offset(y = 100.dp)
         .verticalScroll(scrollState)
   ) {
      Text(
         text = "#${itemInfo.data.id} ${
            itemInfo.data.name.replaceFirstChar {
               if (it.isLowerCase()) it.titlecase(
                  Locale.ROOT
               ) else it.toString()
            }
         }",
         fontWeight = FontWeight.Bold,
         fontSize = 30.sp,
         textAlign = TextAlign.Center,
         color = MaterialTheme.colorScheme.onSurface
      )
   }
}