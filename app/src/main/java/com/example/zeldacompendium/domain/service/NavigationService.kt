package com.example.zeldacompendium.domain.service

import androidx.navigation.NavController

interface NavigationService {
   fun navigateTo(destination: String)
}
class NavigationServiceImpl(private val navController: NavController) : NavigationService {
   override fun navigateTo(destination: String) {
      navController.navigate(destination)
   }
}
