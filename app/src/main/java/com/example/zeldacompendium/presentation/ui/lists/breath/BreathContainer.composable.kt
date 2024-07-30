@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.presentation.ui.lists.breath

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.domain.CompendiumFilter
import com.example.zeldacompendium.domain.CompendiumFilterImpl
import com.example.zeldacompendium.presentation.ui.components.SearchBar
import com.example.zeldacompendium.presentation.ui.components.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.components.categoryselector.CategorySelector
import com.example.zeldacompendium.presentation.ui.components.SetFrame
import com.example.zeldacompendium.presentation.ui.lists.ImageList
import com.example.zeldacompendium.presentation.ui.lists.breath.components.CompendiumItemBreathEmpty
import com.example.zeldacompendium.presentation.ui.lists.breath.components.CompendiumList

@Composable
fun BreathContainer(
   gameId: Int?,
   navController: NavController,
   viewModel: CompendiumBreathViewModel = hiltViewModel(),
   compendiumFilter: CompendiumFilter = CompendiumFilterImpl()
) {
   var selectedIndex by remember { mutableIntStateOf(0) }
   var searchText by remember { mutableStateOf("") }
   val isLoading by remember { viewModel.isLoading }
   val isError by remember { viewModel.loadError }
   val focusManager = LocalFocusManager.current
   val filteredList = compendiumFilter.filterCompendiumList(viewModel.compendiumList.value, selectedIndex)
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
               containerColor = Color.Transparent,
               titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = { },
            navigationIcon = {
               IconButton(onClick = {
                  focusManager.clearFocus()
                  navController.popBackStack() }) {
                  Icon(
                     imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                     tint = Color(0xFF19FFFF),
                     contentDescription = "Localized description"
                  )
               }
            },
         )
      },
      bottomBar = {
         if (isError.isEmpty()) {
            Column(
               modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
            ) {
               SearchBar(
                  onSearch = { query ->
                     searchText = query
                     viewModel.searchCompendium(query)
                  }
               )
               CategorySelector { newSelectedIndex ->
                  focusManager.clearFocus()
                  selectedIndex = newSelectedIndex
               }
            }
         }
      }
   ) { padding ->
      SetBackgroundImage()
      SetFrame()
      Box(
         modifier = Modifier
            .padding(padding)
      ) {
         if (filteredList.isEmpty() && !isLoading && isError.isEmpty()) {
            Column(modifier = Modifier.padding(16.dp)) {
               ImageList(gameId = gameId)
               CompendiumItemBreathEmpty()
            }
         } else {
            CompendiumList(
               gameId = gameId,
               compendiumList = filteredList
            )
         }
         
      }
   }
}