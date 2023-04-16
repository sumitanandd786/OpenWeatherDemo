package com.openweatherdemo.di

import com.openweatherdemo.domain.datasource.currentWeather.CurrentWeatherLocalDataSource
import com.openweatherdemo.domain.datasource.currentWeather.CurrentWeatherRemoteDataSource
import com.openweatherdemo.domain.datasource.forecast.ForecastLocalDataSource
import com.openweatherdemo.domain.datasource.forecast.ForecastRemoteDataSource
import com.openweatherdemo.domain.datasource.searchCities.SearchCitiesLocalDataSource
import com.openweatherdemo.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.openweatherdemo.repo.CurrentWeatherRepository
import com.openweatherdemo.repo.ForecastRepository
import com.openweatherdemo.repo.SearchCitiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(
        currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource,
        currentWeatherLocalDataSource: CurrentWeatherLocalDataSource,
    ) = CurrentWeatherRepository(currentWeatherRemoteDataSource, currentWeatherLocalDataSource)

    @Provides
    @Singleton
    fun provideForecastRepository(
        forecastRemoteDataSource: ForecastRemoteDataSource,
        forecastLocalDataSource: ForecastLocalDataSource,
    ) = ForecastRepository(forecastRemoteDataSource, forecastLocalDataSource)

    @Provides
    @Singleton
    fun provideSearchCitiesRepository(
        searchCitiesRemoteDataSource: SearchCitiesRemoteDataSource,
        searchCitiesLocalDataSource: SearchCitiesLocalDataSource,
    ) = SearchCitiesRepository(searchCitiesRemoteDataSource, searchCitiesLocalDataSource)

}