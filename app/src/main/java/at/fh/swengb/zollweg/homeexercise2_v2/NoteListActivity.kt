package at.fh.swengb.zollweg.homeexercise2_v2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    // private val noteList = mutableListOf<Note>()
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var myDb: NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        myDb = NoteRoomDatabase.getDatabase(applicationContext)
        note_reycler_view.layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter()
        note_reycler_view.adapter = noteAdapter

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val UserName = sharedPreferences.getString("User_name", null)
        val UserAge = sharedPreferences.getInt("User_age", -1)

        t_user.text = "Notes for $UserName,$UserAge"
    }

    override fun onResume() {
        val dbItems = myDb.notesDao.findAllNotes()

        noteAdapter.updateData(dbItems)

        super.onResume()
    }


    fun addNote(v: View){
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }
}
