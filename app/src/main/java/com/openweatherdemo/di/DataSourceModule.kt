package com.openweatherdemo.di

import com.asynclib.PlacesClient
import com.openweatherdemo.db.dao.CitiesForSearchDao
import com.openweatherdemo.db.dao.CurrentWeatherDao
import com.openweatherdemo.db.dao.ForecastDao
import com.openweatherdemo.domain.WeatherAppAPI
import com.openweatherdemo.domain.datasource.currentWeather.CurrentWeatherLocalDataSource
import com.openweatherdemo.domain.datasource.currentWeather.CurrentWeatherRemoteDataSource
import com.openweatherdemo.domain.datasource.forecast.ForecastLocalDataSource
import com.openweatherdemo.domain.datasource.forecast.ForecastRemoteDataSource
import com.openweatherdemo.domain.datasource.searchCities.SearchCitiesLocalDataSource
import com.openweatherdemo.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRemoteDataSource(api: WeatherAppAPI) =
        CurrentWeatherRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideForecastRemoteDataSource(api: WeatherAppAPI) =
        ForecastRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideSearchCitiesRemoteDataSource(
        client: PlacesClient,
        moshi: Moshi,
    ) = SearchCitiesRemoteDataSource(client, moshi)

    @Provides
    @Singleton
    fun provideCurrentWeatherLocalDataSource(currentWeatherDao: CurrentWeatherDao) =
        CurrentWeatherLocalDataSource(currentWeatherDao)

    @Provides
    @Singleton
    fun provideForecastLocalDataSource(forecastDao: ForecastDao) =
        ForecastLocalDataSource(forecastDao)

    @Provides
    @Singleton
    fun provideSearchCitiesLocalDataSource(citiesForSearchDao: CitiesForSearchDao) =
        SearchCitiesLocalDataSource(citiesForSearchDao)

}