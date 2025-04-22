package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pills")
data class PillsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val time: String,
    val pillsName: String,
    val amount: String
)
