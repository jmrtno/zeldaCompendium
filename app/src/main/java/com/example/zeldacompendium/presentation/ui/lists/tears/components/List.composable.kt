@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.presentation.ui.lists.tears.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.commons.GlowingCard
import com.example.zeldacompendium.presentation.ui.detail.ItemDetailModalContainer
import com.example.zeldacompendium.presentation.ui.lists.tears.CompendiumTearsViewModel
import timber.log.Timber

@Composable
fun CompendiumList(
   compendiumList: List<CompendiumListEntry>,
   viewModel: CompendiumTearsViewModel = hiltViewModel(),
) {
   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   LazyColumn(contentPadding = PaddingValues(16.dp)) {
      val itemCount = compendiumList.size
      item {
         Image(
            painter = painterResource(id = R.drawable.logo_tears),
            contentDescription = "Zelda totk Logo",
            modifier = Modifier
               .fillMaxWidth()
               .size(120.dp)
               .offset(y = -(15).dp)
         )
      }
      items(itemCount) {
         if (it >= itemCount && !isLoading) {
            LaunchedEffect(key1 = true) {
               viewModel.loadCompendium()
            }
         }
         CompendiumItem(entry = compendiumList[it])
      }
   }
   Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
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
fun CompendiumItem(
   entry: CompendiumListEntry,
   modifier: Modifier = Modifier,
) {

   val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
   var showBottomSheet by remember { mutableStateOf(false) }

   Box(modifier = modifier
      .fillMaxWidth()
      .padding(15.dp)
      .clickable {
         showBottomSheet = true
      }) {
      GlowingCard(
         glowingColor = Color(0xFF005CBA),
         modifier = Modifier
            .height(75.dp),
         cornersRadius = 10.dp
      ) {}
      Row(
         modifier = modifier
            .height(70.dp)
            .padding(horizontal = 15.dp),
         verticalAlignment = Alignment.CenterVertically,
      ) {
         Text(
            modifier = modifier.weight(1.0f),
            maxLines = 1,
            text = entry.compendiumName,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            color = Color.LightGray,
            overflow = TextOverflow.Ellipsis
         )
         Text(
            modifier = modifier.weight(0.4f),
            text = "#${entry.id}",
            textAlign = TextAlign.End,
            maxLines = 1,
            fontSize = 25.sp,
            color = Color.White.copy(alpha = 0.4f)
         )

         if (showBottomSheet) {
            ModalBottomSheet(
               onDismissRequest = {
                  showBottomSheet = false
               },
               containerColor = Color(0XFF0C0D09).copy(alpha = 0.95f),
               scrimColor = Color.Transparent,
               windowInsets = WindowInsets(
                  left = 15.dp,
                  right = 15.dp,
                  top = 85.dp,
                  bottom = 60.dp
               ),
               shape = RoundedCornerShape(20.dp),
               sheetState = sheetState
            ) {
               ItemDetailModalContainer(itemId = entry.id, gameId = 2)
            }
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

//@Preview
//@Composable
//fun CompendiumItePreview() {
//   CompendiumItem(
//      entry = CompendiumListEntry(
//         category = "creatures",
//         imageURL = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/128/image",
//         id = 345,
//         compendiumName = "asdasdas dasdasd asdas fgd dfgdfgdfgd asdasdasdasd"
//      )
//   )
//}