package com.example.zeldacompendium.presentation.ui.lists.breath.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.components.RetrySection
import com.example.zeldacompendium.presentation.ui.lists.ListHeaderImageSection
import com.example.zeldacompendium.presentation.ui.lists.breath.BreathViewModel
import com.example.zeldacompendium.presentation.ui.lists.breath.sections.items.CompendiumItemBreathEmpty
import com.example.zeldacompendium.presentation.ui.lists.breath.sections.items.CompendiumItemBreath

@Composable
fun BreathListSection(
   padding: PaddingValues,
   gameId: Int?,
   filteredList: List<CompendiumListEntry>,
   isLoading: Boolean,
   isError: String
) {
   Box(
      modifier = Modifier.padding(padding)
   ) {
      if (filteredList.isEmpty() && !isLoading && isError.isEmpty()) {
         Column(modifier = Modifier.padding(16.dp)) {
            ListHeaderImageSection(gameId = gameId)
            CompendiumItemBreathEmpty()
         }
      } else {
         CompendiumList(
            gameId = gameId,
            compendiumList = filteredList
         )
      }
   }
}

@Composable
fun CompendiumList(
   gameId: Int?,
   compendiumList: List<CompendiumListEntry>,
   viewModel: BreathViewModel = hiltViewModel(),
) {

   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   LazyColumn(contentPadding = PaddingValues(16.dp)) {
      val itemCount = compendiumList.size
      item {
         ListHeaderImageSection(gameId = gameId)
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
         RetrySection(
            error = loadError,
            buttonTittle = "Retry"
         ) {
            viewModel.loadBreathList()
         }
      }
   }
}
