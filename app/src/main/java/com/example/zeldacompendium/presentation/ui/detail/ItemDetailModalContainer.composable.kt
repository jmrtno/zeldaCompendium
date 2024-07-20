@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Constants
import com.example.zeldacompendium.data.utils.Resource
import com.example.zeldacompendium.presentation.ui.commons.RetrySection
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.CreaturesItemDetailContainer
import com.example.zeldacompendium.presentation.ui.detail.categories.equipment.EquipmentItemDetailContainer
import com.example.zeldacompendium.presentation.ui.detail.categories.materials.MaterialsItemDetailContainer
import com.example.zeldacompendium.presentation.ui.detail.categories.monsters.MonsterItemDetailContainer
import com.example.zeldacompendium.presentation.ui.detail.categories.treasures.TreasureItemDetailContainer
import java.util.Locale

@Composable
fun ItemDetailModalContainer(
   gameId: Int,
   entry: CompendiumListEntry,
   showBottomSheet: Boolean,
   onDismiss: () -> Unit
){
   val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
   if (showBottomSheet) {
      ModalBottomSheet(
         onDismissRequest = { onDismiss() },
         containerColor = Color(0XFF141413),
         shape = RoundedCornerShape(20.dp),
         sheetState = sheetState,
         modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
      ) {
         ItemDetailContainer(
            itemId = entry.id,
            gameId = gameId,
            onDismiss = onDismiss
         )
      }
   }
}

@Composable
fun ItemDetailContainer(
   gameId: Int,
   itemId: Int,
   onDismiss: () -> Unit,
   viewModel: ItemDetailViewModel = hiltViewModel()
) {
   val itemInfo = produceState<Resource<ItemDetailModel>>(initialValue = Resource.Loading()) {
      value = viewModel.getItemInfo(itemId, gameId)
   }.value

   Box(
      modifier = Modifier
         .fillMaxSize()
   ) {
      ItemDetailStateWrapper(
         itemInfo = itemInfo,
         gameId = gameId,
         onDismiss = onDismiss,
         modifier = Modifier
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
   gameId: Int,
   onDismiss: () -> Unit,
   modifier: Modifier = Modifier
) {
   when (itemInfo) {
      is Resource.Success -> {
         ItemDetailSection(
            itemInfo = itemInfo.data!!, gameId = gameId
         )
      }

      is Resource.Error -> {
         RetrySection(
            error = itemInfo.message!!,
            bottomTittle = "Exit"
         ) {
            onDismiss()
         }
      }

      is Resource.Loading -> {
         CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
         )
      }
   }
}

@Composable
fun ItemDetailSection(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   Column(
      verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(bottom = 40.dp)
   ) {
      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
         horizontalArrangement = Arrangement.Start,
         verticalAlignment = Alignment.CenterVertically
      ) {
         Box(
            contentAlignment = Alignment.Center
         ) {
            AsyncImage(
               modifier = Modifier
                  .size(100.dp)
                  .border(0.5.dp, Color.White),
               model = ImageRequest.Builder(LocalContext.current)
                  .data(
                     if (gameId == 1) {
                        itemInfo.data.image
                     } else {
                        R.drawable.placeholder_img
                     }
                  )
                  .placeholder(R.drawable.placeholder_img)
                  .crossfade(true).build(),
               contentDescription = ""
            )
            Image(
               modifier = Modifier.size(129.dp),
               painter = painterResource(id = R.drawable.frame_loaded_image),
               contentDescription = "Image frame",
            )
         }
         Column {
            Text(
               text = itemInfo.data.name.replaceFirstChar {
                  if (it.isLowerCase()) it.titlecase(
                     Locale.ROOT
                  ) else it.toString()
               },
               fontWeight = FontWeight.Bold,
               fontSize = 18.sp,
               textAlign = TextAlign.Start,
               color = Color.White
            )
            Text(
               text = "#${itemInfo.data.id}",
               fontWeight = FontWeight.Bold,
               fontSize = 26.sp,
               textAlign = TextAlign.Start,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            Text(
               text = itemInfo.data.category.replaceFirstChar {
                  if (it.isLowerCase()) it.titlecase(
                     Locale.ROOT
                  ) else it.toString()
               },
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
         }
      }

      Box(
         modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
      ) {
         Text(
            text = itemInfo.data.description,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            color = Color.White
         )
      }
      when (itemInfo.data.category) {
         Constants.CREATURES -> CreaturesItemDetailContainer(itemInfo = itemInfo, gameId = gameId)
         Constants.MONSTERS -> MonsterItemDetailContainer(itemInfo = itemInfo, gameId = gameId)
         Constants.EQUIPMENT -> EquipmentItemDetailContainer(itemInfo = itemInfo, gameId = gameId)
         Constants.MATERIALS -> MaterialsItemDetailContainer(itemInfo = itemInfo, gameId = gameId)
         Constants.TREASURE -> TreasureItemDetailContainer(itemInfo = itemInfo, gameId = gameId)
      }
   }
}