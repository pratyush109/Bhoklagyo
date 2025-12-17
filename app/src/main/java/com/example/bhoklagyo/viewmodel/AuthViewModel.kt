package com.example.bhoklagyo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bhoklagyo.repository.AuthRepository
import com.example.bhoklagyo.repository.AuthRepositoryImpl

class AuthViewModel(
    private val repository: AuthRepository = AuthRepositoryImpl()
) : ViewModel() {

    fun login(email: String, password: String, result: (Boolean, String) -> Unit) {
        repository.login(email, password, result)
    }

    fun register(email: String, password: String, result: (Boolean, String) -> Unit) {
        repository.register(email, password, result)
    }

    fun forgotPassword(email: String, result: (Boolean, String) -> Unit) {
        repository.forgotPassword(email, result)
    }

    fun isUserLoggedIn(): Boolean = repository.isUserLoggedIn()

    fun logout() {
        repository.logout()
    }
}