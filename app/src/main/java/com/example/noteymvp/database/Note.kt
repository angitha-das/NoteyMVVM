package com.example.noteymvp.database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Note {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var noteId: Int = 0
    @ColumnInfo(name = "title")
    var noteTitle: String? = null
    @ColumnInfo(name = "content")
    var noteContent: String? = null
    @ColumnInfo(name = "updatedTime")
    var noteUpdatedTime: Date? = null
}

