package own.project.notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController = rememberNavController(), viewModel: HomeViewModel = viewModel()){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route) {
            HomeView(navController,viewModel)
        }
        composable(Screen.DetailScreen.route){
            DetailView(navController = navController)
        }
    }
}