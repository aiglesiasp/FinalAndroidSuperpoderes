package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getHeros() : Flow<List<HeroRemote>>
    suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>>
    suspend fun getHeroSeries(id: Int): Flow<List<SeriesRemote>>
    suspend fun getHeroComics(id: Int): Flow<List<ComicsRemote>>
}