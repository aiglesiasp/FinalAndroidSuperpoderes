package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.Mappers
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource, private val mappers: Mappers): Repository {

    override suspend fun getLogin(): Boolean {
        return true
    }

    override suspend fun getHeroes(): Flow<List<Hero>> {
        return remoteDataSource.getHeros()
            .map { heroesList -> mappers.mapHeroRemoteToPresentation(heroesList) }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<Hero>> {
        val result = remoteDataSource.getHeroDetail(id).map { heroList -> mappers.mapHeroRemoteToPresentation(heroList) }
        return result
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<Serie>> {
        val result = remoteDataSource.getHeroSeries(id).map { seriesList-> mappers.mapSerieRemoteToPresentation(seriesList) }
        return result
    }

    override suspend fun getHeroComics(id: Int): Flow<List<Comic>> {
        val result = remoteDataSource.getHeroComics(id).map { comicsList -> mappers.mapComicRemoteToPresentation(comicsList) }
        return result
    }

    override suspend fun navigatetoDetail(): Boolean {
        return true
    }

}