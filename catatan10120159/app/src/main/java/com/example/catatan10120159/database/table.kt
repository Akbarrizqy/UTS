package com.example.catatan10120159.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var date: String = "",
    var judul: String = "",
    var kategori: String = "",
    var note: String = "",
)

//Nim  : 10120159
//Nama : Muhammad Rizqy Akbar
//Kelas: IF-4

