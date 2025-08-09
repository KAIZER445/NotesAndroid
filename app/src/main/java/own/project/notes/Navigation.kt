package own.project.notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(navController: NavHostController = rememberNavController(), viewModel: HomeViewModel = viewModel()){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route) {
            HomeView(navController,viewModel)
        }
        composable(Screen.DetailScreen.route + "/{id}",
            arguments = listOf(navArgument("id"){
                type = NavType.LongType
                defaultValue = 0L
                nullable = false
            })
        ){
            entry->
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            DetailView(navController = navController,viewModel, id = id)
        }
    }
}