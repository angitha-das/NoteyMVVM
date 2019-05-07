package com.example.noteymvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteymvp.R
import com.example.noteymvp.ui.activity.NotesActivity
import com.example.noteymvp.ui.adapter.NoteRecyclerViewAdapter
import com.example.noteymvp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_list_note.*

class ListNoteFragment: Fragment(), NoteRecyclerViewAdapter.ListItemClickListener{


    private lateinit var adapter: NoteRecyclerViewAdapter
    private lateinit var noteViewModel: NoteViewModel
    private var listener: ListNoteInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            noteViewModel = ViewModelProviders.of(it).get(NoteViewModel::class.java)
        }
        return  inflater.inflate(R.layout.fragment_list_note, container, false)
    }

    companion object {
        fun newInstance(): ListNoteFragment {
            return ListNoteFragment()
        }
    }

    fun listAllNotes(){
        listener?.listNotes()
        noteViewModel.getNotes(requireContext())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        adapter = NoteRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(position: Int) {

    }

    interface ListNoteInterface {
        fun listNotes()
    }

}


