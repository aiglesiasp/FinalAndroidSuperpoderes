package com.aiglesiaspubill.finalandroidsuperpoderes.domain

//MARK: PARA EL FILTRO DE SERVIDOR
data class HeroFilter(
    var name: String
)

data class HeroDataWrapper (
    val data : HeroDataContainer
        )

data class HeroDataContainer (
    val results: List<Hero>
        )

data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val modified: String
)
