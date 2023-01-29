package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail

data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)
