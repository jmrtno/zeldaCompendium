package com.example.zeldacompendium.presentation.ui.main

import androidx.lifecycle.ViewModel
import com.example.zeldacompendium.presentation.ui.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   appNavigator: AppNavigator
) : ViewModel() {

   val navigationChannel = appNavigator.navigationChannel
}