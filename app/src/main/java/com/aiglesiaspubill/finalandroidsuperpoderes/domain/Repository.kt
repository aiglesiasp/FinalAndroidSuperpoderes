package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getLogin(): Boolean
    suspend fun getHeroes(): Flow<List<Hero>>
    suspend fun navigatetoDetail(): Boolean
}