package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getLogin(): Boolean
    //suspend fun getHeroes(): Flow<List<Hero>>
    suspend fun navigatetoDetail(): Boolean
    suspend fun getHeroesNew(): Flow<List<HeroRemote>>
    abstract suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>>
}