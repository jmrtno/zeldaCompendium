package com.example.zeldacompendium.presentation.ui.breath.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.breath.CompendiumBreathViewModel
import com.example.zeldacompendium.data.models.CompendiumListEntry

@Composable
fun CompendiumList(
   compendiumList: List<CompendiumListEntry>,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
) {
   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   Column(
      modifier = Modifier
         .fillMaxWidth()
         .verticalScroll(rememberScrollState())
   ) {
      compendiumList.forEachIndexed { index, _ ->
         CompendiumItem(entry = compendiumList[index])
         Divider(color = Color.LightGray)
      }
   }
/*
   Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier.fillMaxSize()
   ) {
      if (isLoading) {
         CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
      }
      if (loadError.isNotEmpty()) {
         RetrySection(error = loadError) {
            viewModel.loadCompendium()
         }
      }
   }*/
}

@Composable
fun CompendiumItem(
   entry: CompendiumListEntry,
   modifier: Modifier = Modifier,
) {
   Row(
      modifier = modifier
         .fillMaxWidth()
         .background(MaterialTheme.colorScheme.surface)
         .height(80.dp)
         .clickable {

         }
         .padding(horizontal = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
   ) {
      Text(
         text = entry.compendiumName,
         fontSize = 22.sp,
         textAlign = TextAlign.Start,
      )
      Box(
         contentAlignment = Alignment.Center
      ) {
         AsyncImage(
            modifier = Modifier
               .size(50.dp)
               .border(0.5.dp, Color.White),
            model = ImageRequest.Builder(LocalContext.current)
               .data(entry.imageURL)
               .placeholder(R.drawable.placeholder_img)
               .crossfade(true)
               .build(),
            contentDescription = entry.compendiumName
         )
         Image(
            modifier = Modifier
               .size(63.dp),
            painter = painterResource(id = R.drawable.frame_loaded_image),
            contentDescription = "Image frame",
         )
      }
   }
}

@Composable
fun RetrySection(
   error: String,
   onRetry: () -> Unit
) {
   Column {
      Text(error, color = Color.Red, fontSize = 18.sp)
      Spacer(modifier = Modifier.height(8.dp))
      Button(
         onClick = { onRetry() },
         modifier = Modifier.align(Alignment.CenterHorizontally)
      ) {
         Text(text = "Retry")
      }
   }
}

@Preview
@Composable
fun CompendiumItePreview() {
   CompendiumItem(
      entry = CompendiumListEntry(
         category = "creatures",
         imageURL = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/128/image",
         number = 1,
         compendiumName = "manolito"
      )
   )
}