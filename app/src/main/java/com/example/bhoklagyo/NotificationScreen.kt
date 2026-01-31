package com.example.bhoklagyo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bhoklagyo.ui.theme.*

data class NotificationItem(val title: String, val message: String)

@Composable
fun NotificationScreen() {

    val notifications = listOf(
        NotificationItem("Order Confirmed 🍔", "Your burger order has been accepted"),
        NotificationItem("Out for Delivery 🛵", "Your food is on the way"),
        NotificationItem("Special Offer 🎉", "Flat 30% off on Pizza today!")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            "Notifications 🔔",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(notifications.size) { index ->
                NotificationCard(notifications[index])
            }
        }
    }
}

@Composable
fun NotificationCard(item: NotificationItem) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {

            Text(
                item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Primary
            )

            Spacer(Modifier.height(4.dp))

            Text(
                item.message,
                color = TextSecondary,
                fontSize = 14.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    MaterialTheme {
        NotificationScreen()
    }
}
