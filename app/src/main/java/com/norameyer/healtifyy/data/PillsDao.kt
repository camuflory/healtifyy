package com.norameyer.healtifyy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
// интерфейс для удаления, добавления и выборки из таблицы таблеток
@Dao
interface PillsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPills(pillsEntity: PillsEntity)

    @Delete
    suspend fun deletePills(pillsEntity: PillsEntity)

    @Query("SELECT * FROM pills")
    fun getAllPills() : Flow<List<PillsEntity>>

}