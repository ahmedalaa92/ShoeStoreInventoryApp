package com.example.shoestoreinventoryapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val imagesList: List<String> = mutableListOf()
) : Parcelable