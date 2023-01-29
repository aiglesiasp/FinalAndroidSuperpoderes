package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail

data class Serie(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail,
    val startYear: Int,
    val endYear: Int
)
