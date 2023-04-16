package com.openweatherdemo.di

import com.openweatherdemo.domain.usecase.CurrentWeatherUseCase
import com.openweatherdemo.domain.usecase.ForecastUseCase
import com.openweatherdemo.domain.usecase.SearchCitiesUseCase
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
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherUseCase(currentWeatherRepository: CurrentWeatherRepository) =
        CurrentWeatherUseCase(currentWeatherRepository)

    @Provides
    @Singleton
    fun provideForecastUseCase(forecastRepository: ForecastRepository) =
        ForecastUseCase(forecastRepository)

    @Provides
    @Singleton
    fun provideSearchCitiesUseCase(searchCitiesRepository: SearchCitiesRepository) =
        SearchCitiesUseCase(searchCitiesRepository)

}