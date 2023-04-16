package com.openweatherdemo.utils

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
