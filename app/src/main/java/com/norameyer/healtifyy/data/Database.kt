package com.norameyer.healtifyy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PressureEntity::class, PillsEntity::class, SugarEntity::class], version = 1)
abstract class MainDB : RoomDatabase() {

    abstract val pressureDao: PressureDao
    abstract val pillsDao: PillsDao
    abstract val sugarDao: SugarDao

    companion object {
        fun createDatabase(context: Context) : MainDB {
            return Room.databaseBuilder(context, MainDB::class.java, "database.db").build()
        }
    }

}