package com.openweatherdemo.domain.datasource.forecast

import com.openweatherdemo.db.dao.ForecastDao
import com.openweatherdemo.db.entity.ForecastEntity
import com.openweatherdemo.domain.model.ForecastResponse
import javax.inject.Inject

class ForecastLocalDataSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun getForecast() = forecastDao.getForecast()

    fun insertForecast(forecast: ForecastResponse) = forecastDao.deleteAndInsert(
        ForecastEntity(forecast)
    )
}
