package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response

import com.squareup.moshi.Json

// MARK: - Welcome
data class SeriesDataWrapper(
    @Json(name = "data") val data: SeriesDataContainer
)


data class SeriesDataContainer(
    @Json(name = "results") val results: List<SeriesRemote>
)

data class SeriesRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail,
    @Json(name = "startYear") val startYear: Int,
    @Json(name = "endYear") val endYear: Int
)
