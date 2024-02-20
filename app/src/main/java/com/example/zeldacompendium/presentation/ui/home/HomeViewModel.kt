package com.example.zeldacompendium.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.example.zeldacompendium.presentation.ui.navigation.AppNavigator
import com.example.zeldacompendium.presentation.ui.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val appNavigator: AppNavigator
) : ViewModel() {

   fun onNavigateToBreathButtonClicked() {
      appNavigator.tryNavigateTo(Destination.BreathScreen())
   }
   fun onNavigateToTearsButtonClicked() {
      appNavigator.tryNavigateTo(Destination.TearsScreen())
   }
}