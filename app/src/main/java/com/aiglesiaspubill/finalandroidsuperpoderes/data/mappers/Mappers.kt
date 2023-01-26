package com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import javax.inject.Inject

class Mappers @Inject constructor() {

    fun mapRemoteToPresentation(heroListRemote: List<HeroDataWrapper>): List<Hero> {
        val list = heroListRemote.flatMap { heroResults -> heroResults.data.results }
        val finalList = mapRemoteToPresentationListHeroRemote(list)
        return finalList

    }

    fun mapRemoteToPresentationListHeroRemote(heroListRemote: List<HeroRemote>): List<Hero> {
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
}