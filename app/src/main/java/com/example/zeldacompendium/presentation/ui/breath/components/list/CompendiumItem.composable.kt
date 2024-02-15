package com.example.zeldacompendium.presentation.ui.breath.components.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.models.CompendiumListEntry

@Composable
fun CompendiumItem(
   entry: CompendiumListEntry,
   modifier: Modifier = Modifier,
) {
   Box(modifier = modifier
      .padding(top = 30.dp)
      .clickable { }
   ) {
      Column(
         modifier = modifier
            .zIndex(1f)
            .padding(horizontal = 40.dp),
      ) {
         Box(
            modifier = modifier
               .offset(y = (-22).dp),
            contentAlignment = Alignment.Center
         ) {
            AsyncImage(
               modifier = modifier
                  .size(50.dp)
                  .border(0.5.dp, Color.White),
               model = ImageRequest.Builder(LocalContext.current)
                  .data(entry.imageURL)
                  .placeholder(R.drawable.placeholder_img)
                  .crossfade(true)
                  .build(),
               contentDescription = entry.compendiumName
            )
            Image(
               modifier = modifier
                  .size(63.dp),
               painter = painterResource(id = R.drawable.frame_loaded_image),
               contentDescription = "Image frame",
            )
         }
         Text(
            modifier = modifier
               .offset(y = (-19).dp),
            text = entry.compendiumName,
            fontSize = 18.sp,
            color = Color.LightGray
         )
      }
      Box(modifier = modifier.fillMaxWidth()) {
         ClickableGlowingCard(
            glowingColor = Color.Cyan,
            modifier = Modifier
               .fillMaxWidth()
               .height(75.dp)
               .padding(horizontal = 15.dp),
            cornersRadius = 10.dp,
            onClick = { }
         ) {}
         Row(
            modifier = modifier
               .fillMaxWidth()
               .padding(horizontal = 15.dp)
               .height(75.dp)
               .padding(end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
         ) {
            Text(
               text = "#${entry.number}",
               fontSize = 25.sp,
               color = Color.White.copy(alpha = 0.4f)
            )
         }
      }

   }
}

@Preview
@Composable
fun CompendiumItePreview() {
   CompendiumItem(
      entry = CompendiumListEntry(
         category = "creatures",
         imageURL = "https://botw-compendium.herokuapp.com/api/v3/compendium/entry/128/image",
         number = 345,
         compendiumName = "asdasdas dasdasd asdas"
      )
   )
}