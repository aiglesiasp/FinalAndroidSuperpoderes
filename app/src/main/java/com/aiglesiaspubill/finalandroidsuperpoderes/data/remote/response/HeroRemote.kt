package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response

import com.squareup.moshi.Json

data class HeroDataWrapper(
    @Json(name = "data") val data: HeroDataContainer
)

data class HeroDataContainer(
    @Json(name = "results") val results: List<HeroRemote>
)

data class HeroRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "thumbnail") val thumbnail: Thumbnail
)
