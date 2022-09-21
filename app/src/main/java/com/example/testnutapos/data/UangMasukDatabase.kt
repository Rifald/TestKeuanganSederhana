package com.example.testnutapos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UangMasuk::class],version =1,exportSchema = false)
abstract class UangMasukDatabase:RoomDatabase()  {
    abstract fun uangMasukDao():UangMasukDao

    companion object{
        private var INSTANCE: UangMasukDatabase?= null

        fun getDatabase(context: Context):UangMasukDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UangMasukDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }

    }
}