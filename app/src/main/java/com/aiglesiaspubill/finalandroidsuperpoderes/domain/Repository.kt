package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getLogin(): Boolean
    suspend fun navigatetoDetail(): Boolean
    suspend fun getHeroes(): Flow<List<Hero>>
    suspend fun getHeroDetail(id: Int): Flow<List<Hero>>
    suspend fun getHeroSeries(id: Int): Flow<List<Serie>>
    suspend fun getHeroComics(id: Int): Flow<List<Comic>>
}