package com.example.bhoklagyo.model

import androidx.annotation.DrawableRes

data class ProductModel(
    val productId: Int,
    val name: String,
    val price: Double,
    val description: String,
    @DrawableRes val imageRes: Int
)
