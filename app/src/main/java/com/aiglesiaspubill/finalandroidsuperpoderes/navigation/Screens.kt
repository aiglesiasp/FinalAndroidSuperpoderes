package com.aiglesiaspubill.finalandroidsuperpoderes.navigation

import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero

sealed class Screens(val route: String) {
    object Login: Screens(HOME_BASE_ROUTE)
    object HeroList: Screens(LIST_BASE_ROUTE)
    object Detail: Screens(route = DETAIL_BASE_ROUTE) {
        fun createRoute(hero: Hero): String {
            return "$DETAIL_BASE_ROUTE/$hero"
        }

    }

    companion object {
        private const val HOME_BASE_ROUTE = "home"
        private const val LIST_BASE_ROUTE = "list"
        private const val DETAIL_BASE_ROUTE = "detail"
        private const val DETAIL_ROUTE = "detail/{id}/{name}?logged={logged}"
    }
}