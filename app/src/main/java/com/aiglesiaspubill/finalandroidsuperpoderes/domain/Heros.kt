package com.aiglesiaspubill.finalandroidsuperpoderes.domain

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail
import com.squareup.moshi.Json

//MARK: PARA EL FILTRO DE SERVIDOR

data class Hero (
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)
