package com.example.noteymvp.database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity
class Note {
    @PrimaryKey
    @ColumnInfo(name = "note_Id")
    var noteId: Int = 0
    @ColumnInfo(name = "note_Title")
    var noteTitle: String? = null
    @ColumnInfo(name = "note_Content")
    var noteContent: String? = null
}

