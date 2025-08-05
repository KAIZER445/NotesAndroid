package own.project.notes.data

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun addNotes(notes: Notes){
        notesDao.addNote(notes)
    }

}