package com.aiglesiaspubill.finalandroidsuperpoderes.ui

sealed class Screens(val route: String) {
    object Login: Screens("login")
    object HeroList: Screens("heroList")
    object Detail: Screens (route = "detail")
}