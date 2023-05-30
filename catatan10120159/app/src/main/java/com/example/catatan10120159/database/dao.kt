package com.example.catatan10120159.database

import androidx.room.*

@Dao
interface DataDao {
    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNote(): List<Note>

}
//Nim  : 10120159
//Nama : Muhammad Rizqy Akbar
//Kelas: IF-4
