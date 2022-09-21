package com.example.testnutapos.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UangMasukViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<UangMasuk>>
    private val repository: UangMasukRepository

    init {
        val uangMasukDao = UangMasukDatabase.getDatabase(application).uangMasukDao()
        repository = UangMasukRepository(uangMasukDao)
        readAllData = repository.readAllData
    }

    fun adddata(uangMasuk: UangMasuk){
        viewModelScope.launch ( Dispatchers.IO){
            repository.addUser(uangMasuk)

        }
    }
}