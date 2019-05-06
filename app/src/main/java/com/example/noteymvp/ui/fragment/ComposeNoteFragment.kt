package com.example.noteymvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.noteymvp.R
import com.example.noteymvp.viewmodel.NoteViewModel

class ComposeNoteFragment:Fragment() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            noteViewModel = ViewModelProviders.of(it).get(NoteViewModel::class.java)
        }
        return  inflater.inflate(R.layout.fragment_compose_note, container, false)
    }

    companion object {
        fun newInstance(): ComposeNoteFragment {
            return ComposeNoteFragment()
        }
    }

}