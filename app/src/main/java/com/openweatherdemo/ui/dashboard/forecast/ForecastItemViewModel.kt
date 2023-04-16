package com.openweatherdemo.ui.dashboard.forecast

import androidx.databinding.ObservableField
import com.openweatherdemo.core.BaseViewModel
import com.openweatherdemo.domain.model.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
