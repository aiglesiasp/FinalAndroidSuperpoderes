package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: MarvelAPI): RemoteDataSource {

    override suspend fun getHeros(): Flow<List<HeroRemote>> {
        val result = api.getHeros().data.results
        return flow { emit(result) }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        val result = api.getHeroDetail(id).data.results
        return flow { emit(result) }
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<SeriesRemote>> {
        val result = api.getHeroSeries(id).data.results
        return flow { emit(result) }
    }

    override suspend fun getHeroComics(id: Int): Flow<List<ComicsRemote>> {
        val result = api.getHeroComics(id).data.results
        return flow { emit(result) }
    }


}
