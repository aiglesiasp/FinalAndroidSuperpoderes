package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelAPI): RemoteDataSource {

    override suspend fun getHeros(): Flow<List<HeroRemote>> {
        val result = api.getHeros()
        return flow { emit(result) }.map { heroList -> heroList.data.results }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        val result = api.getHeroDetail(id)
        return flow { emit(result.data.results) }
    }
}
