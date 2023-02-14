package com.aiglesiaspubill.finalandroidsuperpoderes.resources.utils

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.ComicLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.SerieLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.ComicsRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.SeriesRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie

fun generateToken(): String {
    return "123456"
}


// GENERADORES LOCALES
fun generateHerosLocal(): List<HeroLocal> {
    return (0 until 10).map {
        HeroLocal(1, "Paco", "", Thumbnail("", ""))
    }
}

fun generateSerieLocal(): List<SerieLocal> {
    return (0 until 10).map {
        SerieLocal(1, "Paco", "", Thumbnail("", ""), 1, 2)
    }
}

fun generateComicLocal(): List<ComicLocal> {
    return (0 until 10).map {
        ComicLocal(1, "Paco", "", Thumbnail("", ""))
    }
}


//GENERADORES REMOTOS
fun generateHerosRemote(): List<HeroRemote> {
    return (0 until 10).map {
        HeroRemote(1, "Paco", "", Thumbnail("", ""))
    }
}

fun generateHerosRemote1(): List<HeroRemote> {
    return (0 until 10).map {
        HeroRemote(1, "Aitor", "", Thumbnail("", ""))
    }
}

fun generateSeriesRemote(): List<SeriesRemote> {
    return (0 until 10).map {
        SeriesRemote(1, "Paco", "", Thumbnail("", ""), 1, 2)
    }
}

fun generateSeriesRemote1(): List<SeriesRemote> {
    return (0 until 10).map {
        SeriesRemote(1, "Aitor", "", Thumbnail("", ""), 1, 2)
    }
}

fun generateComicsRemote(): List<ComicsRemote> {
    return (0 until 10).map {
        ComicsRemote(1, "Paco", "", Thumbnail("", ""))
    }
}

fun generateComicsRemote1(): List<ComicsRemote> {
    return (0 until 10).map {
        ComicsRemote(1, "Aitor", "", Thumbnail("", ""))
    }
}


//GENERADORES DE PRESENTACION
fun generateHeros(): List<Hero> {
    return (0 until 10).map {
        Hero(1, "Paco", "", Thumbnail("", ""))
    }
}

fun generateHeros1(): List<Hero> {
    return (0 until 10).map {
        Hero(1, "Aitor", "", Thumbnail("", ""))
    }
}

fun generateSeries(): List<Serie> {
    return (0 until 10).map {
        Serie(1, "Paco", "", Thumbnail("", ""), 1, 2)
    }
}

fun generateSeries1(): List<Serie> {
    return (0 until 10).map {
        Serie(1, "Aitor", "", Thumbnail("", ""), 1, 2)
    }
}

fun generateComics(): List<Comic> {
    return (0 until 10).map {
        Comic(1, "Paco", "", Thumbnail("", ""))
    }
}

fun generateComics1(): List<Comic> {
    return (0 until 10).map {
        Comic(1, "Aitor", "", Thumbnail("", ""))
    }
}
