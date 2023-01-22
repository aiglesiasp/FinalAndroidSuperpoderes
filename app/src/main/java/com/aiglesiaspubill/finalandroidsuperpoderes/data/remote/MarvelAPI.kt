package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote

import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import retrofit2.http.GET

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getHeros(): List<HeroDataWrapper>
}