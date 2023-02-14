package com.aiglesiaspubill.finalandroidsuperpoderes.data

import com.aiglesiaspubill.finalandroidsuperpoderes.data.local.LocalDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.ComicMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.HeroMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.SerieMapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.RemoteDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.fakes.FakeLocalDataSource
import com.aiglesiaspubill.finalandroidsuperpoderes.fakes.FakeRemoteDataSource
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryImplTest {

    //UUT o SUT
    private lateinit var sut: RepositoryImpl
    private lateinit var fakeRemoteDataSource: RemoteDataSource
    private lateinit var fakeLocalDataSource: LocalDataSource
    private lateinit var mapperHero: HeroMapper
    private lateinit var mapperComic: ComicMapper
    private lateinit var mapperSerie: SerieMapper

    @Before
    fun setup() {
        fakeLocalDataSource = FakeLocalDataSource()
        fakeRemoteDataSource = FakeRemoteDataSource()
        mapperHero = HeroMapper()
        mapperComic = ComicMapper()
        mapperSerie = SerieMapper()
        sut = RepositoryImpl(fakeRemoteDataSource,fakeLocalDataSource, mapperHero, mapperSerie, mapperComic)
    }


    @Test
    fun `When_GETHEROS_expect_valid_data` () = runTest {
        //GIVEN
        //WHEN
        val actual = sut.getHeroes().toList()
        //THEN
        assert(actual[0][0].name == "Paco")

    }

    @Test
    fun `When_getherosDetail_expect_valid_date` () = runTest {
        //When
        val actual = sut.getHeroDetail(1).toList()
        //Then
        assert(actual[0][0].name == "Aitor")

    }

    @Test
    fun `WHEN_getSeries_expect_valid_date` () = runTest {
        val actual = sut.getHeroSeries(1).toList()
        assert(actual[0][0].title == "Paco")
    }


    @Test
    fun `WHEN_getComics_expect_valid_date` () = runTest {
        val actual = sut.getHeroComics(1).toList()
        assert(actual[0][0].title == "Paco")
    }

}