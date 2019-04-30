package com.example.noteymvp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteymvp.R




class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, 1)
        recyclerView.layoutManager = staggeredGridLayoutManager



    }

//    private fun getListItemData(): List<ItemObjects> {
//        val listViewItems = ArrayList<ItemObjects>()
//        listViewItems.add(ItemObjects("Alkane", R.drawable.one))
//        listViewItems.add(ItemObjects("Ethane", R.drawable.two))
//        listViewItems.add(ItemObjects("Alkyne", R.drawable.three))
//        listViewItems.add(ItemObjects("Benzene", R.drawable.four))
//        listViewItems.add(ItemObjects("Amide", R.drawable.one))
//        listViewItems.add(ItemObjects("Amino Acid", R.drawable.two))
//        listViewItems.add(ItemObjects("Phenol", R.drawable.three))
//        listViewItems.add(ItemObjects("Carbonxylic", R.drawable.four))
//        listViewItems.add(ItemObjects("Nitril", R.drawable.one))
//        listViewItems.add(ItemObjects("Ether", R.drawable.two))
//        listViewItems.add(ItemObjects("Ester", R.drawable.three))
//        listViewItems.add(ItemObjects("Alcohol", R.drawable.four))
//
//        return listViewItems
//    }
}
