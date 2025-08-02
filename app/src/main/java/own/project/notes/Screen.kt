package own.project.notes

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home-screen")
    object DetailScreen: Screen("detail-screen")
}