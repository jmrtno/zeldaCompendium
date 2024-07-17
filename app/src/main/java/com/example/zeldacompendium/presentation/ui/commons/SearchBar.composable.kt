package com.example.zeldacompendium.presentation.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
   modifier: Modifier = Modifier,
   hint: String = "Search...",
   onSearch: (String) -> Unit = {}
) {
   var text by remember { mutableStateOf("") }
   var isHintDisplayed by remember { mutableStateOf(hint != "") }
   Box(
      modifier = modifier.padding(horizontal = 15.dp),
      contentAlignment = Alignment.CenterEnd
      ) {
         Box {
            BasicTextField(
               value = text,
               onValueChange = {
                  text = it
                  onSearch(it)
               },
               maxLines = 1,
               singleLine = true,
               textStyle = TextStyle(color = Color.LightGray),
               cursorBrush = SolidColor(Color.LightGray),
               modifier = Modifier
                  .fillMaxWidth()
                  .background(Color(0XFF0C0D09), RoundedCornerShape(20))
                  .border(
                     width = 1.dp,
                     color = Color.LightGray.copy(alpha = 0.5f),
                     shape = RoundedCornerShape(20)
                  )
                  .padding(horizontal = 20.dp, vertical = 12.dp)
                  .onFocusChanged {
                     isHintDisplayed = it.isFocused != true
                  }
            )
            if (isHintDisplayed && text.isEmpty()) {
               Text(
                  text = hint,
                  color = Color.LightGray,
                  modifier = Modifier
                     .padding(horizontal = 20.dp, vertical = 8.dp)
               )
            }
         }
         if (text.isNotEmpty()) {
            IconButton(onClick = {
               text = ""
               onSearch("")}
            ) {
               Icon(
                  imageVector = Icons.Outlined.Clear,
                  tint = Color.LightGray,
                  contentDescription = "clear text"
               )
            }
         }
      }
}

@Preview
@Composable
fun DefaultPreview() {
   SearchBar(onSearch = {})
}