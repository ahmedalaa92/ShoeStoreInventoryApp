package com.example.shoestoreinventoryapp.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _navigateToWelcomeScreen = MutableLiveData<Boolean>()
    val navigateToWelcomeScreen: LiveData<Boolean>
        get() = _navigateToWelcomeScreen

    init {
        _navigateToWelcomeScreen.value = false
    }

    fun onSignUpButtonClick() {
        _navigateToWelcomeScreen.value = true
    }

    fun onLoginWithExistingAccountButtonClick() {
        _navigateToWelcomeScreen.value = true
    }

    fun onNavigationDone() {
        _navigateToWelcomeScreen.value = false
    }

    override fun onCleared() {
        super.onCleared()
        _navigateToWelcomeScreen.value = false
    }
}