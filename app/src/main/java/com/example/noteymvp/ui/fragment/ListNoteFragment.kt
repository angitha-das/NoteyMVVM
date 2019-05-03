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
import com.example.noteymvp.ui.adapter.NoteRecyclerViewAdapter
import com.example.noteymvp.viewmodel.ListNoteViewModel
import kotlinx.android.synthetic.main.fragment_list_note.*

class ListNoteFragment: Fragment(), NoteRecyclerViewAdapter.ListItemClickListener{

    private lateinit var adapter: NoteRecyclerViewAdapter
    private lateinit var listNoteViewModel: ListNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.let {
            listNoteViewModel = ViewModelProviders.of(it).get(ListNoteViewModel::class.java)
        }

        return  inflater.inflate(R.layout.fragment_list_note, container, false)
    }

    companion object {
        fun newInstance(): ListNoteFragment {
            return ListNoteFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        adapter = NoteRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(position: Int) {
    }

}


