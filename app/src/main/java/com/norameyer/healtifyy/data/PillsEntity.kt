package com.norameyer.healtifyy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// класс-объект для таблицы pills
@Entity(tableName = "pills")
data class PillsEntity(
    @PrimaryKey(autoGenerate = true) // автоматическое заполнение id
    val id: Int? = null,
    val time: String,
    val pillsName: String,
    val amount: String
)
