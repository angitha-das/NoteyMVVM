package com.example.noteymvp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteymvp.database.Note
import kotlinx.android.synthetic.main.list_item_view.view.*

class NoteListRecyclerViewAdapter(private val listItemClickListener: ListItemClickListener) : RecyclerView.Adapter<NoteListRecyclerViewAdapter.ListItemViewHolder>() {

    private var mItemsList: List<Note> = ArrayList()

    internal fun addListItem(itemList: List<Note>) {
        this.mItemsList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount() = mItemsList.count()


    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        if (holder is ListViewHolder) {
            holder.setData(mItemsList[position],listItemClickListener)
        }
    }

    interface ListItemClickListener {
        fun onItemClicked(position: Int)
    }

   abstract class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ListViewHolder(itemView: View) : ListItemViewHolder(itemView) {
        private val listItemTitle: TextView = itemView.titleTv
        private val listItemContent: TextView = itemView.contentTv
        fun setData(notes: Note, listItemClickListener: ListItemClickListener) {
            listItemTitle.text = notes.noteTitle
            itemView.setOnClickListener {
                listItemClickListener.onItemClicked(adapterPosition)
            }
        }
    }
}