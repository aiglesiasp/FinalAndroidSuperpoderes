package com.aiglesiaspubill.finalandroidsuperpoderes.fakes

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.LocalDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.generateComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.generateHerosLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.generateHerosRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.generateSerieLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLocalDataSource: LocalDataSource {
    override fun getHeroes(): Flow<List<HeroLocal>> {
        return flow { emit(generateHerosLocal()) }
    }

    override fun insertAllHeros(remoteHero: List<HeroLocal>) {
        TODO("Not yet implemented")
    }

    override fun getSeries(): Flow<List<SerieLocal>> {
        return flow { emit(generateSerieLocal()) }
    }

    override fun insertAllSeries(remoteSerie: List<SerieLocal>) {
        TODO("Not yet implemented")
    }

    override fun getComics(): Flow<List<ComicLocal>> {
        return flow { emit(generateComicLocal()) }
    }

    override fun insertAllComics(remoteComics: List<ComicLocal>) {
        TODO("Not yet implemented")
    }
}