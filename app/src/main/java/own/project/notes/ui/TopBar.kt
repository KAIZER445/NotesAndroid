package own.project.notes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import own.project.notes.HomeViewModel
import own.project.notes.Screen
import own.project.notes.data.Notes


@Composable
fun TopBar(
    navController: NavController,
    currentScreen: String?,
    showIconCheck: Boolean,
    noteInput: Notes?,
    viewModel: HomeViewModel,
    id: Long
){
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
    ) {
        if (currentScreen == "home-screen"){
            Text(
                text = "Home",
                color = Color.White,
                modifier = Modifier.padding(13.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }else{
            IconButton(
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

        if (showIconCheck){
            IconButton(
                onClick = {
                    if (id ==0L){
                        noteInput?.let {
                            viewModel.addNotes(
                                Notes(
                                    title = it.title.trim(),
                                    description = it.description.trim(),
                                    date = it.date
                                )
                            )
                        }
                    }else{
                        noteInput?.let {
                            viewModel.updateNotes(
                                Notes(
                                    id = id,
                                    title = it.title.trim(),
                                    description = it.description.trim(),
                                    date = it.date
                                )
                            )
                        }
                    }
                    scope.launch {
                        navController.navigateUp()
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "submit",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}