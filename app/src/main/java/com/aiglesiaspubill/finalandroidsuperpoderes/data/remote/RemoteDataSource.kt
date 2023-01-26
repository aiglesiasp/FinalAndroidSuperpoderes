package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getHeros() : Flow<List<HeroRemote>>
    suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>>
}