package com.openweatherdemo.ui.dashboard

import com.openweatherdemo.core.BaseViewState
import com.openweatherdemo.db.entity.ForecastEntity
import com.openweatherdemo.utils.domain.Status

class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
