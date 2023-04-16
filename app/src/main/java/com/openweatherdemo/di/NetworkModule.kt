package com.openweatherdemo.di

import android.os.Environment
import com.asynclib.PlacesClient
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.openweatherdemo.core.Constants
import com.openweatherdemo.domain.DefaultRequestInterceptor
import com.openweatherdemo.domain.WeatherAppAPI
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideCache(): Cache =
        Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024)

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(DefaultRequestInterceptor())
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        okHttpClientBuilder: OkHttpClient.Builder,
        cache: Cache,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.NetworkService.BASE_URL)
        .client(okHttpClientBuilder.cache(cache).build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): WeatherAppAPI =
        retrofit.create(WeatherAppAPI::class.java)

    @Provides
    @Singleton
    fun providePlacesClient(): PlacesClient =
        PlacesClient(
            Constants.AlgoliaKeys.APPLICATION_ID,
            Constants.AlgoliaKeys.SEARCH_API_KEY
        )

}