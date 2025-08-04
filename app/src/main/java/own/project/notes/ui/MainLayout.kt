package own.project.notes.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import own.project.notes.R
import own.project.notes.Screen

@Composable
fun MainLayout(
    navController: NavController,
    content:@Composable (paddingValues: androidx.compose.foundation.layout.PaddingValues) -> Unit
){

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        topBar = {
            TopBar(navController = navController, currentRoute)
        },
        floatingActionButton ={
            if(currentRoute == "home-screen"){
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.route)
                    },
                    containerColor = colorResource(id = R.color.orange),
                    contentColor = Color.White
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        }
    ) {
        paddingValues -> content(paddingValues)
    }
}