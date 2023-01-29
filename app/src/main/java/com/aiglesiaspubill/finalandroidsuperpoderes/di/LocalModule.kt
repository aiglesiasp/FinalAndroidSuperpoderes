package com.aiglesiaspubill.finalandroidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.HeroDAO
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.HeroDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HeroDataBase {
        return Room.databaseBuilder(context, HeroDataBase::class.java, "database-name").build()
    }

    @Provides
    fun provideDao(database: HeroDataBase): HeroDAO {
        return database.getDAO()
    }
}