@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zeldacompendium.ui.breath

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.ui.breath.components.CategorySelector

@Composable
fun BreathContainer(
   navController: NavController,
) {
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
            }
         )
      },
   ) { padding ->
      Column(
         modifier = Modifier.padding(padding)
      ) {
         Image(
            painter = painterResource(id = R.drawable.logo_botw),
            contentDescription = "Zelda botw Logo",
            modifier = Modifier.fillMaxWidth()
         )
         CategorySelector()
      }
   }
}