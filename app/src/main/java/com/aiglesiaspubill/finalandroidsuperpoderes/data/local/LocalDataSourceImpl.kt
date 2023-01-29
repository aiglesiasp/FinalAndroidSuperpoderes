package com.aiglesiaspubill.finalandroidsuperpoderes.data.local

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: HeroDAO) : LocalDataSource {
    override fun getHeroes(): Flow<List<HeroLocal>> {
        return dao.getAllHeros()
    }

    override fun insertAllHeros(remoteHero: List<HeroLocal>) {
        dao.insertAllHeros(remoteHero)
    }

    override fun getSeries(): Flow<List<SerieLocal>> {
        return dao.getAllSeries()
    }

    override fun insertAllSeries(remoteSerie: List<SerieLocal>) {
        dao.insertAllSeries(remoteSerie)
    }

    override fun getComics(): Flow<List<ComicLocal>> {
        return dao.getAllComics()
    }

    override fun insertAllComics(remoteComics: List<ComicLocal>) {
        dao.insertAllComics(remoteComics)
    }

}