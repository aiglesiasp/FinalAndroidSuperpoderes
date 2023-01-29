package com.aiglesiaspubill.finalandroidsuperpoderes.data.local

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getHeroes(): Flow<List<HeroLocal>>
    fun insertAllHeros(remoteHero: List<HeroLocal>)
    fun getSeries(): Flow<List<SerieLocal>>
    fun insertAllSeries(remoteSerie: List<SerieLocal>)
    fun getComics(): Flow<List<ComicLocal>>
    fun insertAllComics(remoteComics: List<ComicLocal>)
}