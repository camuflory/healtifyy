package com.norameyer.healtifyy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
// интерфейс для удаления, добавления и выборки из таблицы давления
@Dao
interface PressureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPressure(pressureEntity: PressureEntity)

    @Delete
    suspend fun deletePressure(pressureEntity: PressureEntity)

    @Query("SELECT * FROM pressure")
    fun getAllPressure() : Flow<List<PressureEntity>>

}