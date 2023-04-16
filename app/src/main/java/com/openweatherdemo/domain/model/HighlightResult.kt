package com.openweatherdemo.domain.model

import com.openweatherdemo.domain.model.Name
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HighlightResult(

    @Json(name = "country")
    val country: Country? = null,

    @Json(name = "name")
    val name: Name? = null
)
