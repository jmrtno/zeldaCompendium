package com.example.zeldacompendium.presentation.ui.lists.breath.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.lists.ImageList
import com.example.zeldacompendium.presentation.ui.lists.breath.CompendiumBreathViewModel

@Composable
fun CompendiumList(
   gameId: Int?,
   compendiumList: List<CompendiumListEntry>,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
) {

   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   LazyColumn(contentPadding = PaddingValues(16.dp)) {
      val itemCount = compendiumList.size
      item {
         ImageList(gameId = gameId)
      }
      items(itemCount) {
         if (it >= itemCount && !isLoading) {
            LaunchedEffect(key1 = true) {
               viewModel.loadBreathList()
            }
         }
         CompendiumItemBreath(entry = compendiumList[it])
      }
   }
   Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
   ) {
      if (isLoading) {
         CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
      }
      if (!isLoading && loadError.isNotEmpty()) {
         RetrySection(error = loadError) {
            viewModel.loadBreathList()
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