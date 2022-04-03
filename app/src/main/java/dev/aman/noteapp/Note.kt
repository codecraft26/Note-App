package dev.aman.noteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @ColumnInfo(name="text")val note:String,val text:String) {
    @PrimaryKey(autoGenerate = true) var id=0
    //set changes to 0

}
