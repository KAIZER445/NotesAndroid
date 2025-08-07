package own.project.notes

import android.content.Context
import androidx.room.Room
import own.project.notes.data.NotesDatabase
import own.project.notes.data.NotesRepository

object Graph {
    lateinit var database: NotesDatabase

    val notesRepository by lazy {
        NotesRepository(notesDao = database.notesDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, NotesDatabase::class.java,"noteList.db").build()
    }
}