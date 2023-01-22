package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.request.HeroRequest
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarvelAPI {

    @POST("api/heros/all")
    suspend fun getHeros(@Body heroRequest: HeroRequest, @Header("Authorization") token: String): List<Hero>
}