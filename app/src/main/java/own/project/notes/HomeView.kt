package own.project.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import own.project.notes.data.Notes
import own.project.notes.data.dummyNotes
import own.project.notes.ui.TopBar


val dummyData = dummyNotes
@Composable
fun HomeView(){
    Scaffold(
        topBar = {
                 TopBar()
        },
        floatingActionButton ={
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorResource(id = R.color.orange),
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.Black)
            ) {
                for (i in 0 until dummyData.noteList.size) {
                    Column(
                        modifier = Modifier
                            .padding(6.dp)
                            .background(
                                colorResource(id = R.color.darker_gray),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text = dummyData.noteList[i].title,
                                color = Color.White,
                            )
                            Spacer(modifier = Modifier.padding(bottom = 4.dp))
                            Text(
                                text = dummyData.noteList[i].description,
                                color = Color.Gray
                            )
                        }

                    }
                }
            }
    }
}
