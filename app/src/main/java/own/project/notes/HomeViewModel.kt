package own.project.notes

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import own.project.notes.data.Notes
import own.project.notes.data.NotesRepository
import own.project.notes.data.dummyNotes

class HomeViewModel(
    private val notesRepository: NotesRepository = Graph.notesRepository
) : ViewModel(){

    lateinit var getAllNotes: Flow<List<Notes>>

    init {
        viewModelScope.launch {
            getAllNotes = notesRepository.getNotes()
        }
    }

    fun addNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.addNotes(notes)
        }
    }

    fun updateNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.updateNotes(notes)
        }
    }

    fun getNotesFromId(id: Long):Flow<Notes> {
        return notesRepository.getNotesFromId(id)
    }

    fun deleteNotes(notes: Notes){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteNotes(notes)
        }
    }
}