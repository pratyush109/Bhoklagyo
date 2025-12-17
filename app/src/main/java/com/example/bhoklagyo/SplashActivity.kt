package com.example.bhoklagyo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bhoklagyo.ui.theme.Primary
import com.example.bhoklagyo.ui.theme.White
import com.example.bhoklagyo.viewmodel.AuthViewModel
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = AuthViewModel()

            LaunchedEffect(Unit) {
                delay(2000)
                if (viewModel.isUserLoggedIn()) {
                    startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
                } else {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }
                finish()
            }

            SplashUI()
        }
    }
}

@Composable
fun SplashUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.food_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "BhokLagyo",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = White
        )

        Text(
            text = "Delicious food, delivered fast",
            color = White.copy(0.8f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        CircularProgressIndicator(color = White)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashUI()
}