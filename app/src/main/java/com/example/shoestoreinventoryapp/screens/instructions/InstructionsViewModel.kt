package com.example.shoestoreinventoryapp.screens.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private var _navigateToShoeListScreen = MutableLiveData<Boolean>()
    val navigateToShoeListScreen: LiveData<Boolean>
        get() = _navigateToShoeListScreen

    init {
        _navigateToShoeListScreen.value = false
    }

    fun onGetStartedButtonClicked() {
        _navigateToShoeListScreen.value = true
    }

    fun onNavigationDone() {
        _navigateToShoeListScreen.value = false
    }

}