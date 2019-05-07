package com.example.noteymvp.ui.fragment

import android.content.Context
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

class ComposeNoteFragment:Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private var listener: SaveNoteInterface? = null

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

    fun addNewNote(){
        listener?.saveNotes()

        if(noteTitle.text.isNotEmpty()|| noteTitle.text.isNotBlank() || noteDescription.text.isNotEmpty() || noteDescription.text.isNotBlank()){
            noteViewModel.addNote(noteTitle.text.toString(),noteDescription.text.toString(),requireContext())
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SaveNoteInterface) {
            listener = context
        } else {
            throw RuntimeException("$context must implement SaveNoteInterface")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface SaveNoteInterface {
        fun saveNotes()
    }

}