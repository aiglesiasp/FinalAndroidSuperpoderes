package com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import javax.inject.Inject

class Mappers @Inject constructor() {

    fun mapHeroRemoteToPresentation(heroListRemote: List<HeroRemote>): List<Hero> {
        return heroListRemote.map { mapRemoteToPresentationOneHero(it) }

    }

    fun mapRemoteToPresentationOneHero(heroRemote: HeroRemote): Hero {
        return Hero(
            heroRemote.id,
            heroRemote.name,
            heroRemote.description,
            heroRemote.thumbnail
        )
    }

    fun mapSerieRemoteToPresentation(serieListRemote: List<SeriesRemote>): List<Serie> {
        return serieListRemote.map { mapRemoteToPresentationOneSerie(it) }

    }

    fun mapRemoteToPresentationOneSerie(seriesRemote: SeriesRemote): Serie {
        return Serie(
            seriesRemote.id,
            seriesRemote.title,
            seriesRemote.description,
            seriesRemote.thumbnail,
            seriesRemote.startYear,
            seriesRemote.endYear
        )
    }

    fun mapComicRemoteToPresentation(comicsListRemote: List<ComicsRemote>): List<Comic> {
        return comicsListRemote.map { mapRemoteToPresentationOneComic(it) }

    }

    fun mapRemoteToPresentationOneComic(comicsRemote: ComicsRemote): Comic {
        return Comic(
            comicsRemote.id,
            comicsRemote.title,
            comicsRemote.description,
            comicsRemote.thumbnail
        )
    }
}