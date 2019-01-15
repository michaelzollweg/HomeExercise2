package at.fh.swengb.zollweg.homeexercise2_v2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {


    private lateinit var myDb: NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        myDb = NoteRoomDatabase.getDatabase(applicationContext)
    }

    fun saveNote(v: View){

        val title = Title.text.toString()
        val content  = Content.text.toString()

        // if (title.isEmpty() || content.isEmpty())
        //     return

        val newNote = Note(title,content)

        myDb.notesDao.insert(newNote)

        finish()
    }
}
