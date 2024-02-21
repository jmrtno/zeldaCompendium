package com.example.zeldacompendium.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.presentation.ui.commons.GlowingCard
import com.example.zeldacompendium.presentation.ui.lists.breath.components.ItemImage
import java.util.Locale

@Composable
fun ItemDetailScreen(
   itemId: Int,
   viewModel: ItemDetailViewModel = hiltViewModel()
) {
   val itemInfo = produceState<Resource<ItemDetailModel>>(initialValue = Resource.Loading()) {
      value = viewModel.getItemInfo(itemId)
   }.value

   Box(
      modifier = Modifier
         .fillMaxSize()
   ) {
      ItemDetailStateWrapper(
         itemInfo = itemInfo,
         loadingModifier = Modifier
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
fun ItemDetailStateWrapper(
   itemInfo: Resource<ItemDetailModel>,
   modifier: Modifier = Modifier,
   loadingModifier: Modifier = Modifier
) {
   when (itemInfo) {
      is Resource.Success -> {
         ItemDetailSection(
            itemInfo = itemInfo.data!!
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
) {
   Column(
      verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Text(
         text = itemInfo.data.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
               Locale.ROOT
            ) else it.toString()
         },
         fontWeight = FontWeight.Bold,
         fontSize = 26.sp,
         textAlign = TextAlign.Center,
         color = Color.White
      )
      Box(
         modifier = Modifier.padding(top = 35.dp),
         contentAlignment = Alignment.Center
      ) {
         AsyncImage(
            modifier = Modifier
               .size(100.dp)
               .border(0.5.dp, Color.White),
            model = ImageRequest.Builder(LocalContext.current).data(itemInfo.data.image)
               .placeholder(R.drawable.placeholder_img).crossfade(true).build(),
            contentDescription = ""
         )
         Image(
            modifier = Modifier.size(129.dp),
            painter = painterResource(id = R.drawable.frame_loaded_image),
            contentDescription = "Image frame",
         )
      }
      Box(
         contentAlignment = Alignment.Center
      ) {
         GlowingCard(
            modifier = Modifier
               .padding(
                  top = 40.dp,
                  start = 30.dp,
                  end = 30.dp,
                  bottom = 60.dp
               ),
            glowingColor = Color(0xFF005CBA),
            cornersRadius = 10.dp
         ) {
         }
      }
   }
}