package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelAPI): RemoteDataSource {

    override suspend fun getHeros(): Flow<List<HeroDataWrapper>> {
        val result = runCatching { api.getHeros() }

        return flow { emit(result) }.map { heroList -> heroList.getOrThrow() }
    }
}
