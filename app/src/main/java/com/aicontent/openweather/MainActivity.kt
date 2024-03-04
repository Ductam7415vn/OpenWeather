package com.aicontent.openweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aicontent.openweather.ui.theme.OpenWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(height = 100.dp, width = 100.dp)
    ) {
        var isClick by remember {
            mutableStateOf(true)
        }

        if (isClick) {
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Button(
            onClick = { isClick = !isClick },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            val icon = if (isClick) Icons.Default.Done else Icons.Default.Close
            Icon(
                imageVector = icon,
                contentDescription = if (isClick) "open" else "close"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpenWeatherTheme {
        Greeting("Android")
    }
}