package com.example.zeldacompendium.presentation.ui.tears.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.presentation.ui.tears.CompendiumTearsViewModel

@Composable
fun CompendiumList(
   compendiumList: List<CompendiumListEntry>,
   viewModel: CompendiumTearsViewModel = hiltViewModel(),
){
   val loadError by remember { viewModel.loadError }
   val isLoading by remember { viewModel.isLoading }

   LazyColumn(modifier = Modifier.fillMaxWidth()) {
      val itemCount = compendiumList.size
      items(itemCount) {
         CompendiumItem(entry = compendiumList[it])
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
         .clickable {

         }
         .padding(vertical = 10.dp, horizontal = 10.dp)
         .height(70.dp)
         .border(
            BorderStroke(2.dp, Color(0xFF946D48)),
            shape = RoundedCornerShape(10.dp)
         )
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
         modifier = modifier.weight(0.3f),
         text = "#${entry.number}",
         textAlign = TextAlign.End,
         maxLines = 1,
         fontSize = 25.sp,
         color = Color.White.copy(alpha = 0.4f)
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

@Preview
@Composable
fun CompendiumItePreview() {
   CompendiumItem(
      entry = CompendiumListEntry(
         category = "creatures",
         imageURL = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/128/image",
         number = 345,
         compendiumName = "asdasdas dasdasd asdas fgd dfgdfgdfgd asdasdasdasd"
      )
   )
}