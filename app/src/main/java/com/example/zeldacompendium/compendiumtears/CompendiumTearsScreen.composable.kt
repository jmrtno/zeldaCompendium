@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.compendiumtears

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.compendiumtears.components.CategorySelector

@Composable
fun CompendiumTearsScreen(
   navController: NavController,
   viewModel: CompendiumTearsViewModel = hiltViewModel()
){
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
               titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
               Text(
                  "Compendium TOTK",
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
            }
         )
      },
   ) { padding ->
      CategorySelector(paddingValues = padding)
   }
}