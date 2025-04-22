package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pressure")
data class PressureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val pressure: String,
    val time: String,
    val arm: String
)
