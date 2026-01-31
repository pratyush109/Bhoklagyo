package com.example.bhoklagyo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bhoklagyo.model.ProductModel
import com.example.bhoklagyo.repository.ProductRepository

class ProductViewModel : ViewModel() {

    private val repo = ProductRepository()

    private val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>> = _products

    fun loadProducts() {
        _products.value = repo.getProducts()
    }
}
