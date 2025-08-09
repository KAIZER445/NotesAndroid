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
