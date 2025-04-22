package com.norameyer.healtifyy.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PillsScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = { Text(text = "Таблетки", fontSize = 22.sp) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
        )
    }
}