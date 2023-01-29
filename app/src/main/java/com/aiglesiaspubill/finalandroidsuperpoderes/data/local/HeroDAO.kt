package com.aiglesiaspubill.finalandroidsuperpoderes.data.local

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDAO {

    @WorkerThread
    @Query("SELECT * FROM heroes")
    fun getAllHeros(): Flow<List<HeroLocal>>

    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHeros(hero: List<HeroLocal>)

    @WorkerThread
    @Query("SELECT * FROM comics")
    fun getAllComics(): Flow<List<ComicLocal>>

    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllComics(comic: List<ComicLocal>)

    @WorkerThread
    @Query("SELECT * FROM series")
    fun getAllSeries(): Flow<List<SerieLocal>>

    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSeries(serie: List<SerieLocal>)


}