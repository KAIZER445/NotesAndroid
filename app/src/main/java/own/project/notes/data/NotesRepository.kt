package own.project.notes.data

import kotlinx.coroutines.flow.Flow

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun addNotes(Notes: Notes){
        notesDao.addNote(Notes)
    }

    suspend fun updateNotes(Notes: Notes){
        notesDao.updateNote(Notes)
    }

    suspend fun deleteNotes(Notes: Notes){
        notesDao.deleteNote(Notes)
    }

    fun getNotes (): Flow<List<Notes>> = notesDao.getAllNotes()
}