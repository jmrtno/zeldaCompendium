package com.example.zeldacompendium.presentation.ui.detail.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.data.utils.Constants
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.creatures.CreaturesInfo
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.equipment.EquipmentsInfo
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.materials.MaterialsInfo
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.monsters.MonstersInfo
import com.example.zeldacompendium.presentation.ui.detail.sections.categories.treasures.TreasuresInfo
import java.util.Locale

@Composable
fun InfoCategorySection(
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
         Constants.CREATURES -> CreaturesInfo(itemInfo = itemInfo, gameId = gameId)
         Constants.MONSTERS -> MonstersInfo(itemInfo = itemInfo, gameId = gameId)
         Constants.EQUIPMENT -> EquipmentsInfo(itemInfo = itemInfo, gameId = gameId)
         Constants.MATERIALS -> MaterialsInfo(itemInfo = itemInfo, gameId = gameId)
         Constants.TREASURE -> TreasuresInfo(itemInfo = itemInfo, gameId = gameId)
      }
   }
}