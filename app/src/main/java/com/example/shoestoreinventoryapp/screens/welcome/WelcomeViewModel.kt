package com.example.shoestoreinventoryapp.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private var _navigateToInstructionsScreen = MutableLiveData<Boolean>()
    val navigateToInstructionsScreen: LiveData<Boolean>
        get() = _navigateToInstructionsScreen

    init {
        _navigateToInstructionsScreen.value = false
    }

    fun onNextButtonClicked() {
        _navigateToInstructionsScreen.value = true
    }

    fun onNavigationDone() {
        _navigateToInstructionsScreen.value = false
    }
}