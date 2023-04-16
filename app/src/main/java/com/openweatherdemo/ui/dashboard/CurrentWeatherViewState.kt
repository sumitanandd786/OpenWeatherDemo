package com.openweatherdemo.ui.dashboard

import com.openweatherdemo.core.BaseViewState
import com.openweatherdemo.db.entity.CurrentWeatherEntity
import com.openweatherdemo.utils.domain.Status

class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: CurrentWeatherEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
