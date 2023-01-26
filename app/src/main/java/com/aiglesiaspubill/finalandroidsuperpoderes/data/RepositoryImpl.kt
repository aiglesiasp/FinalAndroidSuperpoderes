package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource): Repository {

    private val TAG_TOKEN =
        "eyJraWQiOiJwcml2YXRlIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJpZGVudGlmeSI6IkM3QTZBRENFLUM3MjUtNDlFRi04MEFDLTMxNDVCODkxQzg5NC" +
                "IsImV4cGlyYXRpb24iOjY0MDkyMjExMjAwLCJlbWFpbCI6ImFpZ2xlc2lhc3B1YmlsbEBnbWFpbC5jb20ifQ.NjSKR" +
                "-UPBTVSNIKunr8QPjwUiZJcnUObOv0pYG28Avc"

    override suspend fun getLogin(): Boolean {
        return true
    }

//    override suspend fun getHeroes(): Flow<List<Hero>> {
//        return remoteDataSource.getHeros(TAG_TOKEN)
//    }

    override suspend fun getHeroesNew(): Flow<List<HeroRemote>> {
        return remoteDataSource.getHerosNew()
    }

    override suspend fun getHeroDetail(id: Int): Flow<List<HeroRemote>> {
        return remoteDataSource.getHeroDetail(id)
    }

    override suspend fun navigatetoDetail(): Boolean {
        return true
    }

}