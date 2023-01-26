package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): Repository {

    override suspend fun getLogin(): Boolean {
        return true
    }

    override suspend fun getHeroes(): Flow<List<HeroRemote>> {
        return remoteDataSource.getHeros()
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        return remoteDataSource.getHeroDetail(id)
    }

    override suspend fun navigatetoDetail(): Boolean {
        return true
    }

}