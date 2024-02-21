package com.example.zeldacompendium.di

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class LoggingInterceptor : Interceptor {
   override fun intercept(chain: Interceptor.Chain): Response {
      val request: Request = chain.request()

      // Imprimir la URL de la solicitud
      println("URL: ${request.url}")

      // Continuar con la cadena de intercepción
      return chain.proceed(request)
   }
}