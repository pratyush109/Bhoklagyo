package com.example.bhoklagyo.repository

interface AuthRepository {
    fun login(email: String, password: String, result: (Boolean, String) -> Unit)
    fun register(email: String, password: String, result: (Boolean, String) -> Unit)
    fun forgotPassword(email: String, result: (Boolean, String) -> Unit)
    fun isUserLoggedIn(): Boolean
    fun logout()
}