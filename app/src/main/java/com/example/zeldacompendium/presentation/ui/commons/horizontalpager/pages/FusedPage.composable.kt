package com.example.zeldacompendium.presentation.ui.commons.horizontalpager.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.HorizontalPageContainer

@Composable
fun FusedPage(
   itemInfo: ItemDetailModel
){
   val fusedPower = itemInfo.data.fuseAttackPower.toString()

   HorizontalPageContainer(text = "Fused effect") {
      item {
         Text(
            text = "+${fusedPower} attack power",
            fontSize = 14.sp,
            color = Color.White
         )
      }
   }
}