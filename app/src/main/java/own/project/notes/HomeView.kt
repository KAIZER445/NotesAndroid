package own.project.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import own.project.notes.ui.MainLayout


@Composable
fun HomeView(navController: NavController,homeViewModel: HomeViewModel = viewModel()){

    MainLayout(navController = navController, showCheckIcon = false, id = 0L) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.Black)
        ) {
            val noteList = homeViewModel.getAllNotes.collectAsState(initial = listOf())
            for (i in 0 until noteList.value.size) {
                val id = noteList.value[i].id
                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .background(
                            colorResource(id = R.color.darker_gray),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screen.DetailScreen.route + "/$id")
                        }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text = noteList.value[i].title,
                                color = Color.White,
                            )
                            Spacer(modifier = Modifier.padding(bottom = 4.dp))
                            Text(
                                text = noteList.value[i].description,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.padding(bottom = 6.dp))
                            Text(
                                text = noteList.value[i].date,
                                color = Color.Gray,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        IconButton(
                            onClick = {
                                homeViewModel.deleteNotes(noteList.value[i])
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = "back",
                                tint = colorResource(id = R.color.orange),
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}
