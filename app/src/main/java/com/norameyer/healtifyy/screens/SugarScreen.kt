package com.norameyer.healtifyy.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SugarScreen() {
    TopAppBar(
        title = { Text(text = "Сахар", fontSize = 22.sp) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
    )
}