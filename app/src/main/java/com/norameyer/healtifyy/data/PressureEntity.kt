package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// класс-объект для таблицы pressure
@Entity(tableName = "pressure")
data class PressureEntity(
    @PrimaryKey(autoGenerate = true) // автоматическое заполнение id
    val id: Int? = null,
    val pressure: String,
    val time: String,
    val arm: String
)
