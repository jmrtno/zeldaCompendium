package com.example.zeldacompendium.presentation.ui.navigation

sealed class Destination(protected val route: String, vararg params: String) {
   val fullRoute: String = if (params.isEmpty()) route else {
      val builder = StringBuilder(route)
      params.forEach { builder.append("/{${it}}") }
      builder.toString()
   }

   sealed class NoArgumentsDestination(route: String) : Destination(route) {
      operator fun invoke(): String = route
   }

   object HomeScreen : NoArgumentsDestination(HOME_ROUTE)
   object BreathScreen : NoArgumentsDestination(BREATH_ROUTE)
   object TearsScreen : NoArgumentsDestination(TEARS_ROUTE)

   object ItemDetailsScreen : Destination(ITEM_DETAIL_ROUTE, NAME_KEY, CATEGORY) {
      operator fun invoke(name: String, category: String): String = route.appendParams(
         NAME_KEY to name,
         CATEGORY to category
      )
   }

   companion object {
      private const val HOME_ROUTE = "home"
      private const val BREATH_ROUTE = "breath"
      private const val TEARS_ROUTE = "tears"
      private const val ITEM_DETAIL_ROUTE = "item_details"
      private const val NAME_KEY = "name"
      private const val  CATEGORY = "category"
   }
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
   val builder = StringBuilder(this)

   params.forEach {
      it.second?.toString()?.let { arg ->
         builder.append("/$arg")
      }
   }

   return builder.toString()
}