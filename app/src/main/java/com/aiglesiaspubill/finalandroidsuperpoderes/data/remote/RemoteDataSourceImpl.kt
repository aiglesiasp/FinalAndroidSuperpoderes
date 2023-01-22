package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.request.HeroRequest
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelAPI): RemoteDataSource {

    override suspend fun getHeros(token: String): Flow<List<Hero>> {
        val result = api.getHeros(HeroRequest(), "Bearer $token")
        return flow { emit(result) }.map { heroList -> heroList.filter { hero -> hero.photo.contains("alfabetajuega") } }
    }
}
