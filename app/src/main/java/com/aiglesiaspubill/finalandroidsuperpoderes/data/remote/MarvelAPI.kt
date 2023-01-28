package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesDataWrapper
import retrofit2.http.*

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getHeros(): HeroDataWrapper

    @GET("/v1/public/characters/{characterId}")
    suspend fun getHeroDetail(@Path("characterId") id: Int): HeroDataWrapper

    @GET("/v1/public/characters/{characterId}/series")
    suspend fun getHeroSeries(@Path("characterId") id: Int): SeriesDataWrapper

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getHeroComics(@Path("characterId") id: Int): ComicsDataWrapper
}