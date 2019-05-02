package com.example.noteymvp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Note::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        private const val DATABASE = "Notey_DB"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java,DATABASE)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}