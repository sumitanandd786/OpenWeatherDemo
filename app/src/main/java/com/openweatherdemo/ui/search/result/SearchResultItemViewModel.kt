package com.openweatherdemo.ui.search.result

import androidx.databinding.ObservableField
import com.openweatherdemo.core.BaseViewModel
import com.openweatherdemo.db.entity.CitiesForSearchEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<CitiesForSearchEntity>()
}
