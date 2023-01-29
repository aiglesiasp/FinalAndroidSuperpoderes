package com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import javax.inject.Inject

class SerieMapper @Inject constructor() {


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

    fun mapSerieRemoteToLocal(serieListRemote: List<SeriesRemote>): List<SerieLocal> {
        return serieListRemote.map { mapRemoteToLocalOneSerie(it) }

    }

    fun mapRemoteToLocalOneSerie(seriesRemote: SeriesRemote): SerieLocal {
        return SerieLocal(
            seriesRemote.id,
            seriesRemote.title,
            seriesRemote.description,
            seriesRemote.thumbnail,
            seriesRemote.startYear,
            seriesRemote.endYear
        )
    }

    fun mapSerieLocalToPresentation(serieListLocal: List<SerieLocal>): List<Serie> {
        return serieListLocal.map { mapLocalToPresentationOneSerie(it) }

    }

    fun mapLocalToPresentationOneSerie(seriesLocal: SerieLocal): Serie {
        return Serie(
            seriesLocal.id,
            seriesLocal.title,
            seriesLocal.description,
            seriesLocal.thumbnail,
            seriesLocal.startYear,
            seriesLocal.endYear
        )
    }

}