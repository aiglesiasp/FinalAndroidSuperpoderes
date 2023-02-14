package com.aiglesiaspubill.finalandroidsuperpoderes.fakes

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRemoteDataSource: RemoteDataSource {

    override suspend fun getHeros(): Flow<List<HeroRemote>> {
        return flow { emit(generateHerosRemote()) }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        if (id == 0) {
            return flow { emit(generateHerosRemote()) }
        }
        return flow { emit(generateHerosRemote1()) }
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<SeriesRemote>> {
        if (id == 0) {
            return flow { emit(generateSeriesRemote()) }
        }
        return flow { emit(generateSeriesRemote1()) }
    }

    override suspend fun getHeroComics(id: Int): Flow<List<ComicsRemote>> {
        if (id == 0) {
            return flow { emit(generateComicsRemote()) }
        }
        return flow { emit(generateComicsRemote1()) }
    }
}