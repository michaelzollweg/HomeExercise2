package at.fh.swengb.zollweg.homeexercise2_v2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save (v: View){

        //Name und Age in Shared Preferences speichern


        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        sharedPreferences.edit().putString("User_name", t1_Name.text.toString()).apply()
        sharedPreferences.edit().putInt("User_age",t1_Age.text.toString().toInt()).apply()

        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
