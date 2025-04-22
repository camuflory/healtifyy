package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sugar")
data class SugarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val rate: String,
    val time: String,
)
