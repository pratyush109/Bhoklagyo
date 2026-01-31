package com.example.bhoklagyo

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bhoklagyo.model.ProductModel
import com.example.bhoklagyo.ui.theme.*
import com.example.bhoklagyo.viewmodel.CartViewModel
import com.example.bhoklagyo.viewmodel.ProductViewModel

@Composable
fun HomeScreen() {

    val context = LocalContext.current
    val productVM: ProductViewModel = viewModel()
    val cartVM: CartViewModel = viewModel()

    val products = productVM.products.observeAsState(emptyList())

    LaunchedEffect(Unit) { productVM.loadProducts() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(products.value.size) {
            FoodCard(products.value[it]) {
                cartVM.addToCart(products.value[it])
                Toast.makeText(context, "Added to cart 🛒", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun FoodCard(food: ProductModel, onAddClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {

            // 🍔 Food Image
            Image(
                painter = painterResource(food.imageRes),
                contentDescription = food.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )

            Column(Modifier.padding(12.dp)) {

                Text(
                    text = food.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = food.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    maxLines = 2
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "₹ ${food.price}",
                        style = MaterialTheme.typography.titleMedium,
                        color = Primary,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        onClick = onAddClick,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary)
                    ) {
                        Text("Add", color = White)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BhoklagyoTheme {
        val sampleFoods = listOf(
            ProductModel(1,"Burger",120.0,"Cheesy chicken burger", R.drawable.burger),
            ProductModel(2,"Pizza",250.0,"Loaded cheese pizza", R.drawable.pizza)
        )

        LazyColumn(Modifier.padding(12.dp)) {
            items(sampleFoods.size) {
                FoodCard(sampleFoods[it]) {}
            }
        }
    }
}

