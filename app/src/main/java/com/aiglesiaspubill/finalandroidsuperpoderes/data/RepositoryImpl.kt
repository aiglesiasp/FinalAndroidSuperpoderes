package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): Repository {
    override suspend fun getHeroes(): Flow<List<HeroDataWrapper>> {
        return remoteDataSource.getHeros()
    }

}