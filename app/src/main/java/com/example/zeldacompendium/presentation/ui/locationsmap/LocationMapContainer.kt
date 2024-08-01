package com.example.zeldacompendium.presentation.ui.locationsmap

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.zeldacompendium.data.utils.Constants
import com.example.zeldacompendium.presentation.ui.components.SetFrame

@Composable
fun LocatioMapContainer(
   gameId: Int,
   coordinates: String?
){
   Box(
      modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)
   ) {
      LocationMap(
         gameId = gameId,
         coordinates = coordinates,
         modifier = Modifier.padding(vertical = 22.dp)
      )
      SetFrame()
   }
}

@Composable
fun LocationMap(
   gameId: Int,
   coordinates: String?,
   modifier: Modifier = Modifier
) {
   val locationBreathCoordinates = coordinates?.let { LocationBreathHelper.fromCommonLocation(it) }
   val locationTearsCoordinates = coordinates?.let { LocationTearsHelper.fromCommonLocation(it) }
   val url = when {
      coordinates != null && gameId == 1 -> Constants.BREATH_MAP + "$locationBreathCoordinates"
      coordinates != null && gameId == 2 -> Constants.TEARS_MAP + "$locationTearsCoordinates"
      else -> ""
   }

   AndroidView(
      modifier = modifier,
      factory = { context ->
         WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT,
               ViewGroup.LayoutParams.MATCH_PARENT
            )

            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()

            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            settings.domStorageEnabled = true
            settings.setSupportZoom(true)
         }
      },
      update = { webView ->
         webView.loadUrl(url)
      }
   )
}