package own.project.notes

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import own.project.notes.data.Notes
import own.project.notes.ui.MainLayout
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, viewModel: HomeViewModel, id: Long){
    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }

    var showCheckIcon by remember {
        mutableStateOf((false))
    }

    val currentTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val finalTimeStamp = currentTime.format(formatter)

    val noteInput = Notes(
        title = title.value,
        description = description.value,
        date = finalTimeStamp
    )

    val note by viewModel.getNotesFromId(id).collectAsState(initial = null)
    LaunchedEffect(note) {
        note?.let {
            title.value = it.title
            description.value = it.description
        }
    }

    MainLayout(
        navController = navController,
        showCheckIcon = showCheckIcon,
        noteInput = noteInput
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.Black)
                .fillMaxSize()
        ) {
            TextField(
                value = title.value,
                onValueChange = {
                    title.value =  it
                    showCheckIcon = title.value.isNotBlank() && description.value.isNotBlank()
                                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {Text(
                    text = "Title",
                    style = MaterialTheme.typography.titleLarge
                )},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    cursorColor = colorResource(id = R.color.orange),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                textStyle = MaterialTheme.typography.titleLarge
            )
            Text(
                text = finalTimeStamp,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 17.dp)
            )
            TextField(
                value = description.value,
                onValueChange = {
                    description.value = it
                    showCheckIcon = title.value.isNotBlank() && description.value.isNotBlank()
                                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {Text(
                    text = "start typing",
                    style = MaterialTheme.typography.titleMedium
                )},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    cursorColor = colorResource(id = R.color.orange),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                textStyle = MaterialTheme.typography.titleMedium
            )
        }
    }
}