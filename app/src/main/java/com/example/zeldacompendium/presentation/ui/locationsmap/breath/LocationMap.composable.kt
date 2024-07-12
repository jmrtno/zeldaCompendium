package com.example.zeldacompendium.presentation.ui.locationsmap.breath

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.example.zeldacompendium.presentation.ui.commons.locations.LocationHelper

@Composable
fun LocationMap(
   gameId: Int,
   coordinates: String?
) {
   val locationCoordinates = coordinates?.let { LocationHelper.fromCommonLocation(it) }
   val url = when {
      coordinates != null && gameId == 1 -> "https://objmap.zeldamods.org/#/map/$locationCoordinates"
      coordinates != null && gameId == 2 -> "https://objmap-totk.zeldamods.org/#/map/z6,-554,3272.5,Surface"
      else -> "https://objmap.zeldamods.org/#/map/z3,8,0"
   }

   AndroidView(
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