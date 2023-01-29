package com.aiglesiaspubill.finalandroidsuperpoderes.di

import com.aiglesiaspubill.finalandroidsuperpoderes.data.RepositoryImpl
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.LocalDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.LocalDataSourceImpl
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}