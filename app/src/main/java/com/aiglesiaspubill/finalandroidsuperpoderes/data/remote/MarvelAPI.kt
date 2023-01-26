package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import retrofit2.http.*

interface MarvelAPI {

//    @POST("api/heros/all")
//    suspend fun getHeros(@Body heroRequest: HeroRequest, @Header("Authorization") token: String): List<Hero>

    @GET("/v1/public/characters")
    suspend fun getHerosNew(): HeroDataWrapper

    @GET("/v1/public/characters/{characterId}")
    suspend fun getHeroDetail(@Path("characterId") id: Int): HeroDataWrapper
}