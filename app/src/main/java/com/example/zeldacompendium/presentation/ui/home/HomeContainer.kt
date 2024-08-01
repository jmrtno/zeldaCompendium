package com.example.zeldacompendium.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zeldacompendium.presentation.ui.components.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.components.SetFrame
import com.example.zeldacompendium.presentation.ui.home.sections.GameNavigationSection
import com.example.zeldacompendium.presentation.ui.home.sections.OnBoardingMessageSection

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
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.spacedBy(22.dp),
         modifier = Modifier.padding(
            top = 120.dp,
            start = 20.dp,
            end =  20.dp
         )
      ) {
         GameNavigationSection(navController = navController)
         OnBoardingMessageSection()
      }
      SetFrame()
   }
}