package com.example.testnutapos.data

import androidx.lifecycle.LiveData

class UangMasukRepository (private val uangMasukDao: UangMasukDao) {
    val readAllData: LiveData<List<UangMasuk>> = uangMasukDao.readAllData()

    suspend fun addUser(uangMasuk: UangMasuk) {
        uangMasukDao.adddata(uangMasuk)
    }
}