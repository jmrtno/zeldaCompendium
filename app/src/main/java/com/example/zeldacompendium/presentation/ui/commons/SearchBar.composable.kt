@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.zeldacompendium.presentation.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
   hint: String = "Item name",
   onSearch: (String) -> Unit = {}
) {
   var text by remember { mutableStateOf("") }
   val interactionSource = remember { MutableInteractionSource() }

   Box(modifier = Modifier.padding(horizontal = 15.dp,vertical = 8.dp)) {
      BasicTextField(
         value = text,
         singleLine = true,
         interactionSource = interactionSource,
         cursorBrush = SolidColor(Color.White),
         onValueChange = { newText -> text = newText },
         textStyle = TextStyle(color = Color.LightGray),
         modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color(0XFF0C0D09), RoundedCornerShape(20)),
      ) { innerTextField ->
         OutlinedTextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            interactionSource = interactionSource,
            visualTransformation = VisualTransformation.None,
            placeholder = {
               Text(
                  text = hint,
                  fontStyle = FontStyle.Italic
               )
            },
            leadingIcon = {
               Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = "search icon",
                  tint = Color.LightGray
               )
            },
            trailingIcon = {
               if (text.isNotEmpty()) {
                  IconButton(onClick = {
                     text = ""
                     onSearch("")
                  }) {
                     Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear text icon",
                        tint = Color.LightGray
                     )
                  }
               }
            },
            contentPadding = PaddingValues(),
            container = {
               OutlinedTextFieldDefaults.ContainerBox(
                  enabled = true,
                  isError = false,
                  interactionSource = interactionSource,
                  colors = OutlinedTextFieldDefaults.colors(
                     focusedBorderColor = Color.LightGray
                  ),
                  shape = RoundedCornerShape(20),
                  focusedBorderThickness = 1.dp,
                  unfocusedBorderThickness = 1.dp
               )
            }
         )
      }
   }
}

@Preview
@Composable
fun DefaultPreview() {
   SearchBar(onSearch = {})
}