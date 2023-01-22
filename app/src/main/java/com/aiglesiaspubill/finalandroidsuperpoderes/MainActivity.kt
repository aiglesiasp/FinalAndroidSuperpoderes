package com.aiglesiaspubill.finalandroidsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.Screens
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail.DetailScreen
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList.HeroesListScreen
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.login.LoginScreen
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.theme.FinalAndroidSuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalAndroidSuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screens.Login.route) {
                        composable(Screens.Login.route) {
                            LoginScreen() {
                                navController.navigate(Screens.HeroList.route)
                            }
                        }
                        composable(Screens.HeroList.route) {
                            HeroesListScreen() {
                                navController.navigate(Screens.Detail.route)
                            }
                        }
                        composable(Screens.Detail.route) {
                            DetailScreen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FinalAndroidSuperpoderesTheme {
            Greeting("Android")
        }
    }
}
