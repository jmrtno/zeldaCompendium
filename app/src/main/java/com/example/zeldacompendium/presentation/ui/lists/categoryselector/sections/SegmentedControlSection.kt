package com.example.zeldacompendium.presentation.ui.lists.categoryselector.sections


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.zeldacompendium.presentation.ui.components.NoRippleInteractionSource

@Composable
fun SegmentedControl(
   items: List<Int>,
   itemsSelected: List<Int>,
   defaultSelectedItemIndex: Int = 0,
   itemWidth: Dp = 60.dp,
   cornerRadius : Int = 10,
   onItemSelection: (selectedItemIndex: Int) -> Unit
) {
   val selectedIndex = remember { mutableIntStateOf(defaultSelectedItemIndex) }

   Row(
      modifier = Modifier
   ) {
      items.forEachIndexed { index, _ ->
         Button(
            colors = ButtonDefaults.buttonColors(containerColor  = Color.Transparent),
            modifier = Modifier
               .height(50.dp)
               .width(itemWidth),
            onClick = {
               selectedIndex.intValue = index
               onItemSelection(selectedIndex.intValue)
            },
            interactionSource = NoRippleInteractionSource(),
            shape = when (index) {
               0 -> RoundedCornerShape(
                  topStartPercent = cornerRadius,
                  topEndPercent = 0,
                  bottomStartPercent = cornerRadius,
                  bottomEndPercent = 0
               )
               items.size - 1 -> RoundedCornerShape(
                  topStartPercent = 0,
                  topEndPercent = cornerRadius,
                  bottomStartPercent = 0,
                  bottomEndPercent = cornerRadius
               )
               else -> RoundedCornerShape(
                  topStartPercent = 0,
                  topEndPercent = 0,
                  bottomStartPercent = 0,
                  bottomEndPercent = 0
               )
            },
            contentPadding = PaddingValues(0.dp)
         ) {
            Image(
               painter = painterResource(id = if (selectedIndex.intValue == index) itemsSelected[index] else items[index]),
               contentDescription = null,
               modifier = Modifier
                  .size(40.dp)
            )
         }
      }
   }
}