package com.norameyer.healtifyy.classes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import MainScreen
import com.norameyer.healtifyy.ui.theme.HealtifyyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealtifyyTheme {
                MainScreen()
            }
        }
    }
}
