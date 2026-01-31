package com.example.bhoklagyo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.bhoklagyo.model.CartItem
import com.example.bhoklagyo.model.ProductModel

class CartViewModel : ViewModel() {

    var cartItems = mutableStateListOf<CartItem>()

    fun addToCart(product: ProductModel) {
        val item = cartItems.find { it.product.productId == product.productId }
        if (item != null) item.quantity++ else cartItems.add(CartItem(product))
    }

    fun increase(item: CartItem) { item.quantity++ }

    fun decrease(item: CartItem) {
        if (item.quantity > 1) item.quantity-- else cartItems.remove(item)
    }

    fun totalPrice(): Double = cartItems.sumOf { it.product.price * it.quantity }
}
