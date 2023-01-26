package com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response

// MARK: - Welcome
data class SeriesDataWrapper(
    val data: SeriesDataContainer
)


data class SeriesDataContainer (
    val results: List<Series>
        )

data class Series(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail
)
