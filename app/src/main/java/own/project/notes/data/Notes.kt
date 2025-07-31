package own.project.notes.data

data class Notes(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object dummyNotes {
    val noteList = listOf(
        Notes(1,"Note one", "this note is to remind this is the first note"),
        Notes(2,"Note two", "this note is to remind this is the second note"),
        Notes(3,"Note three","this note is to remind this is the third note")
    )
}