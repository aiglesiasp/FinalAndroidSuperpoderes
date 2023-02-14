package com.aiglesiaspubill.finalandroidsuperpoderes.fakes

import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository: Repository {
    override suspend fun getLogin(): Boolean {
        return true
    }

    override suspend fun getHeroes(): Flow<List<Hero>> {
        return flow { emit(generateHeros()) }
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<Hero>> {
        if (id == 0) {
            return flow { emit(generateHeros()) }
        }
        return flow { emit(generateHeros1()) }
    }

    override suspend fun getHeroSeries(id: Int): Flow<List<Serie>> {
        if (id == 0) {
            return flow { emit(generateSeries()) }
        }
        return flow { emit(generateSeries1()) }
    }

    override suspend fun getHeroComics(id: Int): Flow<List<Comic>> {
        if (id == 0) {
            return flow { emit(generateComics()) }
        }
        return flow { emit(generateComics1()) }
    }
}