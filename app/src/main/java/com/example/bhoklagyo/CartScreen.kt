package com.example.bhoklagyo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bhoklagyo.viewmodel.CartViewModel

@Composable
fun CartScreen() {
    val cartVM: CartViewModel = viewModel()

    Column(Modifier.padding(16.dp)) {
        Text("Cart 🛒")
        LazyColumn {
            items(cartVM.cartItems.size) {
                val item = cartVM.cartItems[it]
                Text("${item.product.name} x ${item.quantity}")
            }
        }
        Text("Total ₹ ${cartVM.totalPrice()}")
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    MaterialTheme {
        CartScreen()
    }
}
