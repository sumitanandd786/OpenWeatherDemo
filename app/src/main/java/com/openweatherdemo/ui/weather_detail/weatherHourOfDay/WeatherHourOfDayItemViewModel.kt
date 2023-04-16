package com.openweatherdemo.ui.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import com.openweatherdemo.core.BaseViewModel
import com.openweatherdemo.domain.model.ListItem
import javax.inject.Inject

class WeatherHourOfDayItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
