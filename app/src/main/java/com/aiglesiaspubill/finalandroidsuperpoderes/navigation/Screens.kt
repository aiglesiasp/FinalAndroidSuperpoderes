package com.aiglesiaspubill.finalandroidsuperpoderes.navigation

sealed class Screens(val route: String) {
    object Login: Screens(HOME_BASE_ROUTE)
    object HeroList: Screens(LIST_BASE_ROUTE)
    object Detail: Screens(route = DETAIL_BASE_ROUTE)

    companion object {
        private const val HOME_BASE_ROUTE = "home"
        private const val LIST_BASE_ROUTE = "list"
        private const val DETAIL_BASE_ROUTE = "detail"
    }
}