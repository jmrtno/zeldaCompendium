@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.presentation.ui.lists.games.tears

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zeldacompendium.domain.CompendiumFilter
import com.example.zeldacompendium.domain.CompendiumFilterImpl
import com.example.zeldacompendium.presentation.ui.components.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.components.SetFrame
import com.example.zeldacompendium.presentation.ui.lists.BottomBarSection
import com.example.zeldacompendium.presentation.ui.lists.TopBarSection
import com.example.zeldacompendium.presentation.ui.lists.games.tears.sections.TearsListSection

@Composable
fun TearsContainer(
   gameId: Int?,
   navController: NavController,
   viewModel: TearsViewModel = hiltViewModel(),
   compendiumFilter: CompendiumFilter = CompendiumFilterImpl()
) {
   val focusManager = LocalFocusManager.current
   var selectedIndex by remember { mutableIntStateOf(0) }
   var searchText by remember { mutableStateOf("") }
   val isLoading by remember { viewModel.isLoading }
   val isError by remember { viewModel.loadError }
   val filteredList = compendiumFilter.filterCompendiumList(viewModel.compendiumList.value, selectedIndex)

   Scaffold(
      topBar = {
         TopBarSection(navController = navController)
      },
      bottomBar = {
         BottomBarSection(
            isError = isError,
            onSearch = { query ->
               searchText = query
               viewModel.searchCompendium(query)
            },
            onCategorySelected = { newSelectedIndex ->
               focusManager.clearFocus()
               selectedIndex = newSelectedIndex
            }
         )
      }
   ) { padding ->
      SetBackgroundImage()
      SetFrame()
      TearsListSection(
         padding = padding,
         gameId = gameId,
         filteredList = filteredList,
         isLoading = isLoading,
         isError = isError
      )
   }
}