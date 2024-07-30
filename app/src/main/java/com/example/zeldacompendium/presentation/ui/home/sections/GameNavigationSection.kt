package com.example.zeldacompendium.presentation.ui.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.presentation.ui.components.CustomButton

@Composable
fun GameNavigationSection(
   navController: NavController,
) {
   Row(
      verticalAlignment = Alignment.CenterVertically
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
                  "compendium_screen/2"
               )
            }
         )
      }
   }
}