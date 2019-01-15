package at.fh.swengb.zollweg.homeexercise2_v2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase: RoomDatabase() {

    abstract val notesDao: NoteDao

    companion object {
        fun getDatabase(context: Context): NoteRoomDatabase {
            return Room.databaseBuilder(context, NoteRoomDatabase::class.java, "note-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}