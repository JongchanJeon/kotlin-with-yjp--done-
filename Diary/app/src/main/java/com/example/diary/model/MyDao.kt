package com.example.diary.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query


@Dao
interface MyDao  {
    @Query("select * from MyRecord order by rid desc")
    fun selectAll():List<MyRecord>

    @Query("select count(*) from  MyRecord where time = time")
    fun checkdate():List<MyRecord>

    @Insert(onConflict = IGNORE)
    suspend fun insert(record: MyRecord)

    @Delete
    suspend fun delete(record: MyRecord)

}