package com.openweatherdemo.domain.datasource.forecast

import com.openweatherdemo.domain.WeatherAppAPI
import com.openweatherdemo.domain.model.ForecastResponse
import io.reactivex.Single
import javax.inject.Inject

class ForecastRemoteDataSource @Inject constructor(private val api: WeatherAppAPI) {

    fun getForecastByGeoCords(lat: Double, lon: Double, units: String): Single<ForecastResponse> = api.getForecastByGeoCords(
        lat,
        lon,
        units
    )
}
