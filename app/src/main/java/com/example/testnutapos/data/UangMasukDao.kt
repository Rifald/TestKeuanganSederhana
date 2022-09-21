package com.example.testnutapos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UangMasukDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun adddata(uangMasuk: UangMasuk)

    @Query("SELECT * FROM UangMasuk ORDER BY UangMasukid ASC")
    fun readAllData(): LiveData<List<UangMasuk>>
}