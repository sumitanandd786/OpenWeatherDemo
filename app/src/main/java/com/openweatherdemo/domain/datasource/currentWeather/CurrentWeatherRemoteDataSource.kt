package com.openweatherdemo.domain.datasource.currentWeather

import com.openweatherdemo.domain.WeatherAppAPI
import com.openweatherdemo.domain.model.CurrentWeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class CurrentWeatherRemoteDataSource @Inject constructor(private val api: WeatherAppAPI) {

    fun getCurrentWeatherByGeoCords(lat: Double, lon: Double, units: String): Single<CurrentWeatherResponse> = api.getCurrentByGeoCords(
        lat,
        lon,
        units
    )
}
