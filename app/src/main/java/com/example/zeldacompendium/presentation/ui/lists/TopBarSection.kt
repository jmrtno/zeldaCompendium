@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.presentation.ui.lists

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController

@Composable
fun TopBarSection(
   focusManager: FocusManager = LocalFocusManager.current,
   navController: NavController
){
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
}