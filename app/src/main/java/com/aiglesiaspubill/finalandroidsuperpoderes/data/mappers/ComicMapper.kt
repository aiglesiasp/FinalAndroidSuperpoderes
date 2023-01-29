package com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import javax.inject.Inject

class ComicMapper @Inject constructor() {

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

    fun mapComicRemoteToLocal(comicsListRemote: List<ComicsRemote>): List<ComicLocal> {
        return comicsListRemote.map { mapRemoteToLocalOneComic(it) }

    }

    fun mapRemoteToLocalOneComic(comicsRemote: ComicsRemote): ComicLocal {
        return ComicLocal(
            comicsRemote.id,
            comicsRemote.title,
            comicsRemote.description,
            comicsRemote.thumbnail
        )
    }

    fun mapComicLocalToPresentation(comicsListLocal: List<ComicLocal>): List<Comic> {
        return comicsListLocal.map { mapLocalToPresentationOneComic(it) }

    }

    fun mapLocalToPresentationOneComic(comicsLocal: ComicLocal): Comic {
        return Comic(
            comicsLocal.id,
            comicsLocal.title,
            comicsLocal.description,
            comicsLocal.thumbnail
        )
    }
}