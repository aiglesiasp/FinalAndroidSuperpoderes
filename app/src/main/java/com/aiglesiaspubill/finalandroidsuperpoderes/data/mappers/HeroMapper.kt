package com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model.HeroLocal
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import javax.inject.Inject

class HeroMapper @Inject constructor() {

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

    fun mapHeroLocalToPresentation(heroLocalList: List<HeroLocal>): List<Hero> {
        return heroLocalList.map { mapLocalToPresentationOneHero(it) }

    }

    fun mapLocalToPresentationOneHero(heroLocal: HeroLocal): Hero {
        return Hero(
            heroLocal.id,
            heroLocal.name,
            heroLocal.description,
            heroLocal.thumbnail
        )
    }

    fun mapHeroRemoteToLocal(heroRemoteList: List<HeroRemote>): List<HeroLocal> {
        return heroRemoteList.map { mapRemoteToLocalOneHero(it) }

    }

    fun mapRemoteToLocalOneHero(heroRemote: HeroRemote): HeroLocal {
        return HeroLocal(
            heroRemote.id,
            heroRemote.name,
            heroRemote.description,
            heroRemote.thumbnail
        )
    }
}