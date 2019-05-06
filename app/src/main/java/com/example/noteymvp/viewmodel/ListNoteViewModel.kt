package com.example.noteymvp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.noteymvp.database.Note
import com.example.noteymvp.repository.NoteRepository

class ListNoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

        fun getNotes(context: Context) = noteRepository.getNotes(context)

        fun addNote(title: String, details: String, context: Context) = noteRepository.addNote(title, details, context)

        fun updateNote(note: Note, context: Context) = noteRepository.updateNote(note, context)

        fun deleteNote(id: String, context: Context) = noteRepository.deleteNote(id, context)

}