package com.aiglesiaspubill.finalandroidsuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal

@Database(entities = [HeroLocal::class, SerieLocal::class, ComicLocal::class], version = 1)
abstract class HeroDataBase : RoomDatabase() {
    abstract fun getDAO(): HeroDAO
}