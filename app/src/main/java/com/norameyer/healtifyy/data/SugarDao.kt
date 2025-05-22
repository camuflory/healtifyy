package com.norameyer.healtifyy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
// итнерфейс для удаления, добавления и выборки из таблицы сахара
@Dao
interface SugarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSugar(sugarEntity: SugarEntity)

    @Delete
    suspend fun deleteSugar(sugarEntity: SugarEntity)

    @Query("SELECT * FROM sugar")
    fun getAllSugar() : Flow<List<SugarEntity>>
}