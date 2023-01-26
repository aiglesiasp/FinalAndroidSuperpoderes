package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import retrofit2.http.*

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getHeros(): HeroDataWrapper

    @GET("/v1/public/characters/{characterId}")
    suspend fun getHeroDetail(@Path("characterId") id: Int): HeroDataWrapper
}