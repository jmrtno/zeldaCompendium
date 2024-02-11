@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.presentation.ui.tears

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zeldacompendium.R
import com.example.zeldacompendium.domain.CompendiumFilter
import com.example.zeldacompendium.domain.CompendiumFilterImpl
import com.example.zeldacompendium.presentation.ui.commons.CategorySelector
import com.example.zeldacompendium.presentation.ui.home.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.tears.components.CompendiumList

@Composable
fun TearsContainer(
   viewModel: CompendiumTearsViewModel = hiltViewModel(),
   compendiumFilter: CompendiumFilter = CompendiumFilterImpl()
) {
   var selectedIndex by remember { mutableStateOf(0) }
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
               containerColor = Color.Transparent,
               titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = { Text("") },
            navigationIcon = {
               IconButton(onClick = { viewModel.onBackButtonClicked() }) {
                  Icon(
                     imageVector = Icons.Filled.ArrowBack,
                     contentDescription = "Localized description"
                  )
               }
            },
            actions = {

            }
         )
      },
      bottomBar = {
         CategorySelector { newSelectedIndex ->
            selectedIndex = newSelectedIndex
         }
      }
   ) { padding ->
      SetBackgroundImage()
      Column(
         modifier = Modifier.padding(padding)
      ) {
         Image(
            painter = painterResource(id = R.drawable.logo_tears),
            contentDescription = "Zelda totk Logo",
            modifier = Modifier
               .fillMaxWidth()
               .size(100.dp)
               .offset(y = (-30).dp)
         )
         val filteredList =  compendiumFilter.filterCompendiumList(viewModel.compendiumList.value, selectedIndex)
         CompendiumList(compendiumList = filteredList)
      }
   }
}