package com.example.zeldacompendium.presentation.ui.breath.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.breath.CompendiumBreathViewModel

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
      }
   }
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