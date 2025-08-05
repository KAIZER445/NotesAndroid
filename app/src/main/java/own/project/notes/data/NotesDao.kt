package own.project.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert()
    abstract suspend fun addNote(noteEntity: Notes)

    @Query("SELECT * FROM `notes-table`")
    suspend fun getAllNotes(): Flow<List<Notes>>

    @Update()
    suspend fun updateNote(noteEntity: Notes)

    @Delete()
    suspend fun deleteNote(noteEntity: Notes)


}