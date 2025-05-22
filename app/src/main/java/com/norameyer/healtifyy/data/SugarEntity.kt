package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// класс-объект для таблицы sugar
@Entity(tableName = "sugar")
data class SugarEntity(
    @PrimaryKey(autoGenerate = true) // автоматическое заполнение id
    val id: Int? = null,
    val rate: String,
    val time: String,
)
