package com.example.noteymvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.noteymvp.R
import com.example.noteymvp.database.AppDatabase
import com.example.noteymvp.database.Note
import com.example.noteymvp.viewmodel.ComposeNoteViewModel
import kotlinx.android.synthetic.main.list_item_view.*

class ComposeNoteFragment:Fragment() {
    private lateinit var composeNoteViewModel: ComposeNoteViewModel
    private val db = activity?.applicationContext?.let { AppDatabase.getInstance(it) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            composeNoteViewModel = ViewModelProviders.of(it).get(ComposeNoteViewModel::class.java)
        }
        return  inflater.inflate(R.layout.fragment_compose_note, container, false)
    }

    companion object {
        fun newInstance(): ComposeNoteFragment {
            return ComposeNoteFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun createNote(){
        //Save new note.
        val note = Note()
        note.noteTitle = titleTv.text.toString()
        note.noteContent =  contentTv.text.toString()
        note.noteUpdatedTime = System.currentTimeMillis()
        db?.noteDao()?.insert(note)
    }

    private fun updateNote(noteId: Int){
        //Update an existing note
    }
}