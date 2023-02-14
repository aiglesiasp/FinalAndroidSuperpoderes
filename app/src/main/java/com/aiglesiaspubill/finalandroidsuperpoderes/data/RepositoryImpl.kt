package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.LocalDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.ComicMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.HeroMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.SerieMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mapperHero: HeroMapper,
    private val mapperSerie: SerieMapper,
    private val mapperComic: ComicMapper
) : Repository {

    override suspend fun getLogin(): Boolean {
        return true
    }

    override suspend fun getHeroes(): Flow<List<Hero>> {
        val localResult = localDataSource.getHeroes()
        if (localResult.first().isEmpty()) {
            val remoteResult = remoteDataSource.getHeros()
                .map { heroList -> mapperHero.mapHeroRemoteToLocal(heroList) }

            withContext(Dispatchers.IO) {
                localDataSource.insertAllHeros(remoteResult.toList().first())
            }
            return remoteResult.map { heroList -> mapperHero.mapHeroLocalToPresentation(heroList) }
        }
        return localResult.map { heroList -> mapperHero.mapHeroLocalToPresentation(heroList) }
    }


    override suspend fun getHeroDetail(id: Int): Flow<List<Hero>> {
        val result = remoteDataSource.getHeroDetail(id)
            .map { heroList -> mapperHero.mapHeroRemoteToPresentation(heroList) }
        return result
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<Serie>> {
        val localResult = localDataSource.getSeries()
        if (localResult.first().isEmpty()) {
            val remoteResult = remoteDataSource.getHeroSeries(id)
                .map { seriesList -> mapperSerie.mapSerieRemoteToLocal(seriesList) }
            withContext(Dispatchers.IO) {
                localDataSource.insertAllSeries(remoteResult.toList().first())
            }
            return remoteResult.map { serieList -> mapperSerie.mapSerieLocalToPresentation(serieList) }
        }
        return localResult.map { serieList -> mapperSerie.mapSerieLocalToPresentation(serieList) }
    }

    override suspend fun getHeroComics(id: Int): Flow<List<Comic>> {
        val localResult = localDataSource.getComics()
        if (localResult.first().isEmpty()) {
            val remoteResult = remoteDataSource.getHeroComics(id)
                .map { comicList -> mapperComic.mapComicRemoteToLocal(comicList) }
            withContext(Dispatchers.IO) {
                localDataSource.insertAllComics(remoteResult.toList().first())
            }
            return remoteResult.map { comicList -> mapperComic.mapComicLocalToPresentation(comicList) }
        }
        return localResult.map { comicList -> mapperComic.mapComicLocalToPresentation(comicList) }
    }


}