package at.fh.swengb.zollweg.homeexercise2_v2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName="Notes")
class Note (
    val title: String,
    val content: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}