package own.project.notes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes-table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "note-title")
    val title: String = "",
    @ColumnInfo(name = "note-description")
    val description: String = "",
    @ColumnInfo(name = "note-date")
    val date: String = ""
)

object dummyNotes {
    val noteList = listOf(
        Notes(1,"Note one", "this note is to remind this is the first note", "2025-08-05 09:32:54"),
        Notes(2,"Note two", "this note is to remind this is the second note","2025-08-05 09:32:54"),
        Notes(3,"Note three","this note is to remind this is the third note","2025-08-05 09:32:54")
    )
}