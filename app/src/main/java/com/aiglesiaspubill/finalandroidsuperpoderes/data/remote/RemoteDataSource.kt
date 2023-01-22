package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getHeros(token: String) : Flow<List<Hero>>
}