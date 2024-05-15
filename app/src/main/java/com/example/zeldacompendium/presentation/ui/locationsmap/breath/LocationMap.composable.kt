package com.example.zeldacompendium.presentation.ui.locationsmap.breath

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun LocationMap(
   gameId: Int
) {
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
         val url = when (gameId) {
            1 -> "https://objmap.zeldamods.org/#/map/z4,-2384,-408"
            else -> "https://objmap-totk.zeldamods.org/#/map/z6,-554,3272.5,Surface"
         }
         webView.loadUrl(url)
      }
   )
}