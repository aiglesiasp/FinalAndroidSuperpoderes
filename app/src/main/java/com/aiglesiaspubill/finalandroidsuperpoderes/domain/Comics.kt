package com.aiglesiaspubill.finalandroidsuperpoderes.domain

data class ComicsDataWrapper(
    val data: ComicsDataContainer
)


data class ComicsDataContainer (
    val results: List<Series>
)

data class Comic(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail
)
