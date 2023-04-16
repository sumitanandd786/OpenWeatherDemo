package com.openweatherdemo.domain.datasource.searchCities

import com.asynclib.PlacesClient
import com.asynclib.PlacesQuery
import com.openweatherdemo.domain.model.SearchResponse
import com.openweatherdemo.utils.extensions.tryCatch
import com.squareup.moshi.Moshi
import io.reactivex.Single
import javax.inject.Inject
import timber.log.Timber

class SearchCitiesRemoteDataSource @Inject constructor(
    private val client: PlacesClient,
    private val moshi: Moshi
) {

    fun getCityWithQuery(query: String): Single<SearchResponse> {
        return Single.create { single ->
            val algoliaQuery = PlacesQuery(query)
                .setLanguage("en")
                .setHitsPerPage(25)

            client.searchAsync(algoliaQuery) { json, exception ->
                if (exception == null) {
                    tryCatch(
                        tryBlock = {
                            val adapter = moshi.adapter<SearchResponse>(SearchResponse::class.java)
                            val data = adapter.fromJson(json.toString())

                            if (data?.hits != null) {
                                single.onSuccess(data)
                            }
                        },
                        catchBlock = {
                            Timber.e(it, it.localizedMessage)
                        }
                    )
                } else {
                    single.onError(Throwable("Can't find '$query'. Please try another one."))
                }
            }
        }
    }
}
