package com.openweatherdemo.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.openweatherdemo.core.Constants
import com.openweatherdemo.db.entity.ForecastEntity
import com.openweatherdemo.repo.ForecastRepository
import com.openweatherdemo.ui.dashboard.ForecastMapper
import com.openweatherdemo.ui.dashboard.ForecastViewState
import com.openweatherdemo.utils.UseCaseLiveData
import com.openweatherdemo.utils.domain.Resource
import javax.inject.Inject

class ForecastUseCase @Inject internal constructor(private val repository: ForecastRepository) : UseCaseLiveData<ForecastViewState, ForecastUseCase.ForecastParams, ForecastRepository>() {

    override fun getRepository(): ForecastRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: ForecastParams?): LiveData<ForecastViewState> {
        return repository.loadForecastByCoord(
            params?.lat?.toDouble() ?: 0.0,
            params?.lon?.toDouble() ?: 0.0,
            params?.fetchRequired
                ?: false,
            units = params?.units ?: Constants.Coords.METRIC
        ).map {
            onForecastResultReady(it)
        }
    }

    private fun onForecastResultReady(resource: Resource<ForecastEntity>): ForecastViewState {
        val mappedList = resource.data?.list?.let { ForecastMapper().mapFrom(it) }
        resource.data?.list = mappedList

        return ForecastViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class ForecastParams(
        val lat: String = "",
        val lon: String = "",
        val fetchRequired: Boolean,
        val units: String
    ) : Params()
}
