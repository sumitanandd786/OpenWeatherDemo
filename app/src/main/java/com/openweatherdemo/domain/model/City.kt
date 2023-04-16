package com.openweatherdemo.domain.model

import android.os.Parcelable
import com.openweatherdemo.domain.model.Coord
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class City(

    @Json(name = "country")
    val country: String?,

    @Json(name = "coord")
    val coord: Coord?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: Int?
) : Parcelable
