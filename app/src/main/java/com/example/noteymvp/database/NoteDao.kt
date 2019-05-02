package com.example.noteymvp.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface  NoteDao {

    @Query("SELECT * FROM Note ORDER BY updatedTime DESC")
    fun getAllNotes(): List<Note>

    @Query("select * from Note where id = :id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = REPLACE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}