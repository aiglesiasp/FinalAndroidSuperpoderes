package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHeroes(): Flow<List<HeroDataWrapper>>
}