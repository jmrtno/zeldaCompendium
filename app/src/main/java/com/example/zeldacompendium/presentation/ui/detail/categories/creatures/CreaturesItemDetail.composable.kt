@file:OptIn(ExperimentalFoundationApi::class)
package com.example.zeldacompendium.presentation.ui.detail.categories.creatures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import com.example.zeldacompendium.domain.service.NavigationService
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.CookingEffectImageProvider
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.Edible
import com.example.zeldacompendium.presentation.ui.detail.categories.creatures.type.NoEdible
import java.util.Locale


object ServiceProvider {
   lateinit var navigationService: NavigationService
}

@Composable
fun CreaturesItemDetail(
   itemInfo: ItemDetailModel,
   gameId: Int
) {
   val pagerState = rememberPagerState(pageCount = { 3 })
   HorizontalPager(
      state = pagerState,
      pageSpacing = 20.dp,
      contentPadding = PaddingValues(
         horizontal = 48.dp,
         vertical = 12.dp
      ),
   ) { page ->
         if (!itemInfo.data.edible) {
            when (page) {
               0 -> Drops(itemInfo)
               1 -> LocationPage(itemInfo, gameId)
            }
         } else {
            when (page) {
               0 -> HealingPage(itemInfo)
               1 -> CookingEffectPage(itemInfo)
               2 -> LocationPage(itemInfo, gameId)
            }
         }
      }


}
@Composable
fun HealingPage(
   itemInfo: ItemDetailModel
){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(
            Color(0XFF0C0D09),
            shape = RoundedCornerShape(20.dp)
         )
   ) {
      Column(
         modifier = Modifier
            .padding(11.dp)
      ) {
         Text(
            text = "Healing",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            color = Color.LightGray.copy(alpha = 0.5f)
         )
         HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
         HeartsRow(itemInfo)
      }
   }
}

@Composable
fun HeartsRow(
   itemInfo: ItemDetailModel,
) {
   val heartsCount = itemInfo.data.heartsRecovered.toInt()

   Row {
      repeat(heartsCount) {
         Image(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
            modifier = Modifier.size(36.dp)
         )
      }
      if (heartsCount == 0) {
         Image(
            painter = painterResource(id = R.drawable.empty_heart),
            contentDescription = "${itemInfo.data.heartsRecovered} hearts recovered",
            modifier = Modifier.size(36.dp)
         )
      }
   }
}

@Composable
fun CookingEffectPage(
   itemInfo: ItemDetailModel
){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(
            Color(0XFF0C0D09),
            shape = RoundedCornerShape(20.dp)
         )
   ) {
      Column(
         modifier = Modifier
            .padding(11.dp)
      ) {
         Text(
            text = "Cooking Effect",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            color = Color.LightGray.copy(alpha = 0.5f)
         )
         HorizontalDivider()
         val imageCookingEffect =
            CookingEffectImageProvider.getImageResource(itemInfo.data.cookingEffect)
         Image(
            painter = painterResource(id = imageCookingEffect),
            contentDescription = "cooking effect",
            modifier = Modifier
               .fillMaxWidth()
               .size(120.dp)
         )
      }
   }
}

@Composable
fun Drops(
   itemInfo: ItemDetailModel
){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(
            Color(0XFF0C0D09),
            shape = RoundedCornerShape(20.dp)
         )
   ) {
      LazyColumn(
         contentPadding = PaddingValues(11.dp),
      ) {
         val dropsCount = itemInfo.data.drops
         item {
            Text(
               text = "Drops",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               fontSize = 24.sp,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
         }
         if (!dropsCount.isNullOrEmpty()) {
            items(dropsCount.size) { drop ->
               Text(
                  text = itemInfo.data.drops[drop].replaceFirstChar {
                     if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                     ) else it.toString()
                  },
                  fontSize = 18.sp,
                  color = Color.White
               )
            }
         } else {
            item {
               Text(
                  text = "None",
                  fontSize = 18.sp,
                  color = Color.White
               )
            }
         }
      }
   }
}

@Composable
fun LocationPage(
   itemInfo: ItemDetailModel,
   gameId: Int
){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(
            Color(0XFF0C0D09),
            shape = RoundedCornerShape(20.dp)
         )
   ) {
      LazyColumn(
         contentPadding = PaddingValues(11.dp)
      ) {
         val locationCount = itemInfo.data.commonLocations
         item {
            Text(
               text = "Location",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               fontSize = 24.sp,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
         }
         if (!locationCount.isNullOrEmpty()) {
            items(locationCount.size) {
               val commonLocation = itemInfo.data.commonLocations[it]
               Text(
                  text = commonLocation,
                  fontSize = 18.sp,
                  color = Color.White,
                  modifier = Modifier
                     .padding(5.dp)
                     .clickable {
                        ServiceProvider
                           .navigationService
                           .navigateTo("locations_map_screen/$gameId/$commonLocation")
                     }
               )
            }
         } else {
            item {
               Text(
                  text = "Not defined",
                  fontSize = 18.sp,
                  color = Color.White
               )
            }
         }
      }
   }
}