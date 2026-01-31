package com.example.bhoklagyo.repository

import com.example.bhoklagyo.R
import com.example.bhoklagyo.model.ProductModel

class ProductRepository {

    fun getProducts(): List<ProductModel> {
        return listOf(
            ProductModel(1,"Burger",120.0,"Cheesy chicken burger", R.drawable.burger),
            ProductModel(2,"Pizza",250.0,"Loaded cheese pizza", R.drawable.pizza),
            ProductModel(3,"Momo",90.0,"Steamed veg momos", R.drawable.momo),
            ProductModel(4,"Pasta",180.0,"White sauce pasta", R.drawable.pasta)
        )
    }
}
