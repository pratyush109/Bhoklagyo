package com.example.bhoklagyo.repository

import com.google.firebase.auth.FirebaseAuth

class AuthRepositoryImpl : AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String, result: (Boolean, String) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { result(true, "Login successful") }
            .addOnFailureListener { result(false, it.message ?: "Login failed") }
    }

    override fun register(email: String, password: String, result: (Boolean, String) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result(true, "Registration successful") }
            .addOnFailureListener { result(false, it.message ?: "Registration failed") }
    }

    override fun forgotPassword(email: String, result: (Boolean, String) -> Unit) {
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener { result(true, "Reset link sent to email") }
            .addOnFailureListener { result(false, it.message ?: "Error") }
    }

    override fun isUserLoggedIn(): Boolean = auth.currentUser != null

    override fun logout() {
        auth.signOut()
    }
}