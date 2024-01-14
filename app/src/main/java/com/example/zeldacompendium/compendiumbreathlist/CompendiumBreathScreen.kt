package com.example.zeldacompendium.compendiumbreathlist

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.utils.Resource
import timber.log.Timber


@Composable
fun CompendiumBreathScreen(
   navController: NavController,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
){
   LaunchedEffect(key1 = true) {
      viewModel.loadCompendium()
   }
   Surface(
      color = MaterialTheme.colorScheme.background,
      modifier = Modifier.fillMaxSize()
   ) {
      Column {
         Spacer(modifier = Modifier.height(30.dp))

         val items = listOf(
            R.drawable.creatures,
            R.drawable.monsters,
            R.drawable.equipment,
            R.drawable.materials,
            R.drawable.treasures
         )

         val itemsSelected = listOf(
            R.drawable.creatures_hint,
            R.drawable.monsters_hint,
            R.drawable.equipment_hint,
            R.drawable.materials_hint,
            R.drawable.treasures_hint
         )
         var selectedIndex by remember { mutableStateOf(0) }
         Row(
            modifier = Modifier
               .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
         ) {
            SegmentedControl(
               items = items,
               itemsSelected = itemsSelected,
               defaultSelectedItemIndex = 0
            ) {
               selectedIndex = it
            }
         }
         val filteredList = when (selectedIndex) {
            0 -> viewModel.compendiumList.value.filter { it.category == "creatures" }
            1 -> viewModel.compendiumList.value.filter { it.category == "monsters" }
            2 -> viewModel.compendiumList.value.filter { it.category == "equipment" }
            3 -> viewModel.compendiumList.value.filter { it.category == "materials" }
            4 -> viewModel.compendiumList.value.filter { it.category == "treasure" }
            else -> emptyList()
         }
         CompendiumList(compendiumList = filteredList)
      }
   }
}
@Composable
fun CompendiumList(
   compendiumList: List<CompendiumListEntry>,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
){
   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   LazyColumn(contentPadding = PaddingValues(16.dp)) {
      val itemCount = compendiumList.size
      items(itemCount) {
         CompendiumItem(entry = compendiumList[it])
         Divider(color = Color.LightGray)
      }
   }

   Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier.fillMaxSize()
   ) {
      if (isLoading) {
         CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
      }
      if(loadError.isNotEmpty()) {
         RetrySection(error = loadError) {
            viewModel.loadCompendium()
         }
      }
   }
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

         },
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
   ) {
      Text(
         text = entry.compendiumName,
         fontSize = 22.sp,
         textAlign = TextAlign.Start,
      )
      AsyncImage(
         model = ImageRequest.Builder(LocalContext.current)
            .data(entry.imageURL)
            .crossfade(true)
            .build(),
         contentDescription = entry.compendiumName,
         modifier = Modifier
            .size(50.dp)
      )
   }
}

@Composable
fun RetrySection(
   error: String,
   onRetry: () -> Unit
){
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