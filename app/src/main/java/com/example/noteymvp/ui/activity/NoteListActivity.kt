package com.example.noteymvp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteymvp.R
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, 1)
        recyclerView.layoutManager = staggeredGridLayoutManager

        addNote.setOnClickListener {
            addNote()
        }

        setSupportActionBar(bottom_app_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_search -> Log.d("TAG","Fav menu search item is clicked!")
        }

        return true
    }

    private fun addNote(){
        val intent = Intent(this, NoteComposeActivity::class.java)
        startActivity(intent)
    }
}
