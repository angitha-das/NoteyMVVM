package com.example.noteymvp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.noteymvp.R
import com.example.noteymvp.ui.fragment.ComposeNoteFragment
import com.example.noteymvp.ui.fragment.ListNoteFragment
import com.example.noteymvp.util.FRAGMENT_COMPOSE_NOTE
import com.example.noteymvp.util.FRAGMENT_LIST_NOTE
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    private var addFab: Boolean = true
    private var selectedFragment: Fragment? = supportFragmentManager.findFragmentByTag(FRAGMENT_LIST_NOTE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.setHasFixedSize(true)
//
//        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, 1)
//        recyclerView.layoutManager = staggeredGridLayoutManager

        if (selectedFragment == null) {
            selectedFragment = ListNoteFragment.newInstance()
        }
        addFragment(selectedFragment!!,FRAGMENT_LIST_NOTE)

        fabIcon.setOnClickListener {
          toggleFunction()
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

    private fun toggleFunction(){
        if(addFab){
            addNote()
        }else{
            saveNote()
        }
        addFab = !addFab
    }

    private fun addNote(){
        //Navigate to compose/update note
        bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        bottom_app_bar.replaceMenu(R.menu.bottomappbar_menu_secondary)
        fabIcon?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_save))

        selectedFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_COMPOSE_NOTE)
        if (selectedFragment == null) {
            selectedFragment = ComposeNoteFragment.newInstance()
        }
        addFragment(selectedFragment!!,FRAGMENT_COMPOSE_NOTE)
    }
    private fun saveNote(){
        //Save and navigate to note listing
        ComposeNoteFragment.newInstance().createNote()
        bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_menu_white_24dp)
        bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        bottom_app_bar.replaceMenu(R.menu.bottomappbar_menu_primary)
        fabIcon?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_add_white_24dp))

        selectedFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_LIST_NOTE)
        if (selectedFragment == null) {
            selectedFragment = ListNoteFragment.newInstance()
        }
        addFragment(selectedFragment!!,FRAGMENT_LIST_NOTE)
    }

    private fun addFragment(fragment: Fragment, fragmentTag: String) {
        val fragmentPopped = supportFragmentManager.popBackStackImmediate(fragmentTag, 0)
        if (!fragmentPopped && supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
            //fragment not in back stack, create it.
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout,fragment,fragmentTag)
                .addToBackStack(fragmentTag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commitAllowingStateLoss()
        }
    }


}

