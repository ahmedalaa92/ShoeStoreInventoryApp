package com.example.shoestoreinventoryapp.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventoryapp.models.Shoe

open class ShoeListViewModel : ViewModel() {

    private var _navigationToAddItem = MutableLiveData<Boolean>()
    val navigationToAddItem: LiveData<Boolean>
        get() = _navigationToAddItem

    private var _shoeNameText = MutableLiveData<String>()
    val shoeNameText: LiveData<String>
        get() = _shoeNameText

    private var _shoeSizeText = MutableLiveData<String>()
    val shoeSizeText: LiveData<String>
        get() = _shoeSizeText

    private var _companyNameText = MutableLiveData<String>()
    val companyNameText: LiveData<String>
        get() = _companyNameText

    private var _shoeDescriptionText = MutableLiveData<String>()
    val shoeDescriptionText: LiveData<String>
        get() = _shoeDescriptionText

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

    fun onSaveButtonClicked(
        shoeName: String, shoeSize: String, companyName: String, description: String
    ) {
        val shoe = Shoe(
            shoeName, shoeSize.toDouble(), companyName, description
        )
        shoeList.value = shoeList.value?.plus(shoe)
        _navigationToShoeList.value = true
    }

    fun onNavigationToAddItemDone() {
        _navigationToAddItem.value = false
    }
    fun onNavigationToShoeListDone() {
        _navigationToShoeList.value = false
    }
}