package own.project.notes

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import own.project.notes.data.Notes
import own.project.notes.data.dummyNotes

class HomeViewModel : ViewModel(){

    private val _noteList = MutableStateFlow(dummyNotes.noteList)

    val noteList:StateFlow<List<Notes>> =_noteList

}