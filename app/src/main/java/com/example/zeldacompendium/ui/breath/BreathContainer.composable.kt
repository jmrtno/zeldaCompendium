@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.ui.breath

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.ui.breath.components.CategorySelector
import com.example.zeldacompendium.ui.breath.components.CompendiumList

@Composable
fun BreathContainer(
   navController: NavController,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
) {
   LaunchedEffect(key1 = true) {
      viewModel.loadCompendium()
   }
   var selectedIndex by remember { mutableStateOf(0) }
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
               titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
               Text(
                  "Compendium BOTW",
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis
               )
            },
            navigationIcon = {
               IconButton(onClick = { navController.popBackStack() }) {
                  Icon(
                     imageVector = Icons.Filled.ArrowBack,
                     contentDescription = "Localized description"
                  )
               }
            },
            actions = {
               IconButton(onClick = {

               }) {
                  Icon(
                     imageVector = Icons.Filled.Menu,
                     contentDescription = "Localized description"
                  )
               }
            },
         )
      },

      bottomBar = {
         CategorySelector { newSelectedIndex ->

            selectedIndex = newSelectedIndex
         }
      }
   ) { padding ->
      Column(
         modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
      ) {
         Image(
            painter = painterResource(id = R.drawable.logo_botw),
            contentDescription = "Zelda botw Logo",
            modifier = Modifier.fillMaxWidth()
         )

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