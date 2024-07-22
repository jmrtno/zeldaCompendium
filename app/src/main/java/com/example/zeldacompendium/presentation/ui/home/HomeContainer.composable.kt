package com.example.zeldacompendium.presentation.ui.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zeldacompendium.R
import com.example.zeldacompendium.data.utils.Constants
import com.example.zeldacompendium.presentation.ui.commons.CustomButton
import com.example.zeldacompendium.presentation.ui.commons.SetBackgroundImage
import com.example.zeldacompendium.presentation.ui.home.component.SetFrame

@Composable
fun HomeContainer(
   navController: NavController,
){
   Surface(
      color = MaterialTheme.colorScheme.surface,
      modifier = Modifier.fillMaxSize()
   ) {
      SetBackgroundImage()
      Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.spacedBy(22.dp),
         modifier = Modifier.padding(
            top = 120.dp,
            start = 20.dp,
            end =  20.dp
         )
      ) {
         GameNavigation(navController = navController)
         OnBoardingMessage()
      }
      SetFrame()
   }
}

@Composable
fun GameNavigation(
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
                  "compendium_screen/1"
               )
            }
         )
      }
   }
}

@Composable
fun OnBoardingMessage() {
   val context = LocalContext.current
   val annotatedText = buildAnnotatedText()
   val (text, inlineContent) = buildAnnotatedIcon()
   Box(
      modifier = Modifier
         .background(
            Color(0xFF121210),
            shape = RoundedCornerShape(15.dp)
         )
         .border(
            width = 2.dp,
            color = Color.LightGray.copy(alpha = 0.5f),
            shape = RoundedCornerShape(15.dp)
         ),
   ) {
      Column(
         modifier = Modifier
            .padding(11.dp)
      ) {

            Text(
               text = "Welcome!",
               fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
               fontSize = 18.sp,
               color = Color.LightGray.copy(alpha = 0.5f)
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 7.dp))
            Text(
               text = text,
               inlineContent = inlineContent,
               style = TextStyle(
                  fontSize = 14.sp,
                  color = Color.LightGray,
                  lineHeight = 20.sp
                  )
            )
            ClickableText(
               text = annotatedText,
               style = TextStyle(
                  fontSize = 14.sp,
                  color = Color.LightGray,
                  lineHeight = 20.sp
               ),
               onClick = { offset ->
                  annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                     .firstOrNull()?.let { annotation ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                        context.startActivity(intent)
                     }
               }
            )
      }
   }
}

@Composable
fun buildAnnotatedIcon(): Pair<AnnotatedString, Map<String, InlineTextContent>> {
   val modId = "modIcon"
   val text = buildAnnotatedString {
      append(Constants.WELCOME_MSG)
      appendInlineContent(modId, "[icon]\n")
   }
   val inlineContent = mapOf(
      Pair(
         modId,
         InlineTextContent(
            Placeholder(
               width = 20.sp,
               height = 20.sp,
               placeholderVerticalAlign = PlaceholderVerticalAlign.Center
            )
         ) {
            Image(
               painter = painterResource(id = R.drawable.map_icon),
               contentDescription = ""
            )
         }
      )
   )
   return Pair(text, inlineContent)
}

@Composable
fun buildAnnotatedText(): AnnotatedString {
   return buildAnnotatedString {
      append(Constants.WELCOME_MSG2)
      withStyle(
         style = SpanStyle(
            color = Color.LightGray,
            textDecoration = TextDecoration.Underline,
            fontStyle = FontStyle.Italic
         )
      ) {
         pushStringAnnotation(tag = Constants.TAG, annotation = Constants.API_URL)
         append(Constants.API_URL_PLACEHOLDER)
         pop()
      }

      append(Constants.WELCOME_MSG3)

      withStyle(
         style = SpanStyle(
            color = Color.LightGray,
            textDecoration = TextDecoration.Underline,
            fontStyle = FontStyle.Italic
         )
      ) {
         pushStringAnnotation(tag = Constants.TAG, annotation = Constants.ZELDA_UI_KIT_URL)
         append(Constants.ZELDA_UI_KIT_URL_PLACEHOLDER)
         pop()
      }
   }
}