package com.aiglesiaspubill.finalandroidsuperpoderes.di

import android.util.Log
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.MarvelAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        return httpLoggingInterceptor
    }
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                Log.d("AUTENTICADOR", "ENTRANDO EN EL INTERCEPTOR")
                val originalRequest = chain.request()
                val newRequest = originalRequest.newBuilder()
                    .header("Content-Type", "Application/Json")
                    .build()
                chain.proceed(newRequest)
            }
            .authenticator { _, response ->
                response.request.newBuilder()
                    .header(
                        "Authorization",
                        "PROBANDO"
                    ).build()
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return okHttpClient
    }

    @Provides
    fun provideMoshi(): Moshi {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        return moshi
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.marvel.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
        return retrofit
    }

    @Provides
    fun provideAPI(retrofit: Retrofit): MarvelAPI {
        var api: MarvelAPI = retrofit.create(MarvelAPI::class.java)
        return api
    }
}