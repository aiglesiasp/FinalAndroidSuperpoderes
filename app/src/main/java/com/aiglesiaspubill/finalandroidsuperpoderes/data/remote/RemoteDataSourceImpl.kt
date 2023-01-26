package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.request.HeroRequest
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelAPI): RemoteDataSource {

//    override suspend fun getHeros(token: String): Flow<List<Hero>> {
//        val result = api.getHeros(HeroRequest(), "Bearer $token")
//        return flow { emit(result) }
//    }

    override suspend fun getHerosNew(): Flow<List<HeroRemote>> {
        val result = api.getHerosNew()
        return flow { emit(result) }.map { heroList -> heroList.data.results }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        val result = api.getHeroDetail(id)
        return flow { emit(result.data.results) }
    }
}
