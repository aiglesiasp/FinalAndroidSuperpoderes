package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response

import com.squareup.moshi.Json

data class ComicsDataWrapper(
    @Json(name = "data") val data: ComicsDataContainer
)


data class ComicsDataContainer (
    @Json(name = "results") val results: List<Series>
)

data class Comic(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail
)
