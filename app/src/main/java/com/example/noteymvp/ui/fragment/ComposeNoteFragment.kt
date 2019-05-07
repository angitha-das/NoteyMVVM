package com.example.noteymvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.noteymvp.R
import com.example.noteymvp.ui.activity.NotesActivity
import com.example.noteymvp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_compose_note.*

class ComposeNoteFragment:Fragment(),NotesActivity.NoteInterface {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            noteViewModel = ViewModelProviders.of(it).get(NoteViewModel::class.java)
        }
       return inflater.inflate(R.layout.fragment_compose_note, container, false)
    }

    companion object {
        fun newInstance(): ComposeNoteFragment {
            return ComposeNoteFragment()
        }
    }

    private fun addNewNote(){
        noteViewModel.addNote(noteTitle.text.toString(),noteDescription.text.toString(),requireContext())
    }

    override fun saveNotes() {
        addNewNote()
    }

    override fun listNotes() {
    }
}