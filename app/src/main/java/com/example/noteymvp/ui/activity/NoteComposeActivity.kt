package com.example.noteymvp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.noteymvp.R
import kotlinx.android.synthetic.main.activity_note_compose.*
import kotlinx.android.synthetic.main.activity_note_compose.bottom_app_bar

class NoteComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_compose)
        saveNote.setOnClickListener {
            saveNote()
        }
        setSupportActionBar(bottom_app_bar)
    }

    private fun saveNote(){
//        val intent = Intent(this, NoteComposeActivity::class.java)
//        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu_secondary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_search -> Log.d("TAG","Fav menu search item is clicked!")
        }

        return true
    }
}
