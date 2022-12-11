package com.example.shoestoreinventoryapp.screens.shoelist

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventoryapp.models.Shoe

open class ShoeListViewModel : ViewModel() {

    private var _navigationToAddItem = MutableLiveData<Boolean>()
    val navigationToAddItem: LiveData<Boolean>
        get() = _navigationToAddItem

    var shoeNameText = MutableLiveData<String>()

    var shoeSizeText = MutableLiveData<String>()

    var companyNameText = MutableLiveData<String>()

    var shoeDescriptionText = MutableLiveData<String>()

    private var _navigationToShoeList = MutableLiveData<Boolean>()
    val navigationToShoeList: LiveData<Boolean>
        get() = _navigationToShoeList

    val shoeList = MutableLiveData<List<Shoe>>(
        mutableListOf(
            Shoe("Nike Air Force 1", 43.0, "Nike", ""),
            Shoe("Adidas Ultra boost 20", 44.0, "Adidas", ""),
            Shoe("New Balance 574", 43.0, "New Balance", "")
        )
    )

    init {
        _navigationToAddItem.value = false
        _navigationToShoeList.value = false
    }

    fun onAddItemButtonClicked() {
        _navigationToAddItem.value = true
    }

    fun onSaveButtonClicked() {
        val shoe = Shoe(
            shoeNameText.value.toString(),
            shoeSizeText.value!!.toDouble(),
            companyNameText.value.toString(),
            shoeDescriptionText.value.toString()
        )
        shoeList.value = shoeList.value?.plus(shoe)
        _navigationToShoeList.value = true
    }

    fun onCancelButtonClicked() {
        _navigationToShoeList.value = true
    }

    fun onNavigationToAddItemDone() {
        _navigationToAddItem.value = false
    }

    fun onNavigationToShoeListDone() {
        _navigationToShoeList.value = false
    }
}