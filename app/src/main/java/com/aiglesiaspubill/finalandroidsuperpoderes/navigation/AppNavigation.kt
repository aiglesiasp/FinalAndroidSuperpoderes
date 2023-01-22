package com.aiglesiaspubill.finalandroidsuperpoderes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail.DetailScreen
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList.HeroesListScreen
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.login.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(Screens.Login.route) {
            LoginScreen() {
                navController.navigate(Screens.HeroList.route)
            }
        }
        composable(Screens.HeroList.route) {
            HeroesListScreen(navController)
        }
        composable(Screens.Detail.route + "/{name}/{photo}/{description}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("photo") { type = NavType.StringType }
            )) {
            val name = it.arguments?.getString("name") ?: "NO HAY NOMBRE"
            val description = it.arguments?.getString("description") ?: "NO HAY DESCRIPCION"
            val photo = it.arguments?.getString("photo") ?: "NO HAY FOTO"
            DetailScreen(name,photo, description)
        }
    }
}