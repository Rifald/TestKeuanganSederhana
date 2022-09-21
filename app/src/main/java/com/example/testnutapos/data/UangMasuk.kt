package com.example.testnutapos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UangMasuk")
data class UangMasuk (
    @PrimaryKey(autoGenerate = true)
    val UangMasukid: Int,
    val TerimaDari:String,
    val Keterangan: String,
    val Jumlah: Int,

    )