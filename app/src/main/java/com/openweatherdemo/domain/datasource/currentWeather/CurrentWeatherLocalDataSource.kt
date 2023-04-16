package com.openweatherdemo.domain.datasource.currentWeather

import com.openweatherdemo.db.dao.CurrentWeatherDao
import com.openweatherdemo.db.entity.CurrentWeatherEntity
import com.openweatherdemo.domain.model.CurrentWeatherResponse
import javax.inject.Inject

class CurrentWeatherLocalDataSource @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao
) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )
}
