package com.example.zeldacompendium.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.commons.CustomButton
import com.example.zeldacompendium.presentation.ui.commons.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.commons.horizontalpager.sections.pages.page.HorizontalPage
import com.example.zeldacompendium.presentation.ui.home.component.SetFrame

@Composable
fun HomeContainer(
   navController: NavController,
){
   Surface(
      color = MaterialTheme.colorScheme.surface,
      modifier = Modifier.fillMaxSize()
   ) {
      SetBackgroundImage()
      Column(
         modifier = Modifier.padding(top = 120.dp, bottom = 70.dp)
      ) {
         GameNavigation(navController = navController)
         OnBoardingMessage()
      }
      SetFrame()
   }
}

@Composable
fun GameNavigation(
   navController: NavController,
) {
   Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(15.dp)
   ) {
      Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.spacedBy(10.dp),
         modifier = Modifier.weight(1f)
      ) {
         Image(
            painter = painterResource(id = R.drawable.link_botw),
            modifier = Modifier.size(125.dp),
            contentDescription = ""
         )
         CustomButton(
            text = "Breath of the Wild",
            modifier = Modifier.size(250.dp, 80.dp),
            onClick = {
               navController.navigate(
                  "compendium_screen/1"
               )
            }
         )
      }

      Column(
         verticalArrangement = Arrangement.spacedBy(10.dp),
         modifier = Modifier.weight(1f),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Image(
            painter = painterResource(id = R.drawable.link_totk),
            modifier = Modifier.size(125.dp),
            contentDescription = ""
         )
         CustomButton(
            text = "Tears of the Kingdom",
            modifier = Modifier.size(250.dp, 80.dp),
            onClick = {
               navController.navigate(
                  "compendium_screen/1"
               )
            }
         )
      }
   }
}

@Composable
fun OnBoardingMessage() {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(horizontal = 20.dp)
         .background(
            Color(0xFF121210),
            shape = RoundedCornerShape(15.dp)
         )
         .border(
            width = 2.dp,
            color = Color.LightGray.copy(alpha = 0.5f),
            shape = RoundedCornerShape(15.dp)
         ),
   ) {
      Column(
         modifier = Modifier.padding(11.dp)
      ) {
         Text(
            text = "Welcome!",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp,
            color = Color.LightGray.copy(alpha = 0.5f)
         )
         HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
      }

   }
}