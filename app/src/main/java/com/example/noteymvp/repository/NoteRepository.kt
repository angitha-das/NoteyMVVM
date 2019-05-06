package com.example.noteymvp.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.noteymvp.database.AppDatabase
import com.example.noteymvp.database.Note

class NoteRepository {

    companion object {
        @Volatile
        private var instance: NoteRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: NoteRepository().also { instance = it }
            }
    }

    private val notes = MutableLiveData<List<Note>>()

    /**
     * Get all the Notes from the database and save them in the notes variable
     * return all the notes objects
     * @param context The context of the Activity that calls this method
     */
    fun getNotes(context: Context){
        val db = AppDatabase.getInstance(context)
        val allNotes = db.noteDao().getAllNotes()

    }

    /**
     * Adding notes to database
     * @param title The title of the note
     * @param details Details of the note
     * @param context The context of the Activity that calls this method
     */
    fun addNote(title: String, details: String, context: Context) {

    }

    /**
     * Updating notes in database
     * @param note The updated Note object that will get saved
     * @param context The context of the Activity calling the function
     */
    fun updateNote(note: Note, context: Context){

    }

    /**
     *  Deleting a note from the database
     * @param id The id of the note that is going to be deleted
     * @param context The context of the Activity calling the function
     */
    fun deleteNote(id: String, context: Context){

    }
}

//https://github.com/TannerGabriel/Notes-App/blob/master/app/src/main/java/com/example/android/noteapp/note/NoteRepository.kt