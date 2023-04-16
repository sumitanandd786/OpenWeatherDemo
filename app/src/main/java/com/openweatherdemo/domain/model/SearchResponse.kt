package com.openweatherdemo.domain.model

import com.openweatherdemo.domain.model.HitsItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(

    @Json(name = "hits")
    val hits: List<HitsItem?>? = null
)
