package com.openweatherdemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.openweatherdemo.db.dao.CitiesForSearchDao
import com.openweatherdemo.db.dao.CurrentWeatherDao
import com.openweatherdemo.db.dao.ForecastDao
import com.openweatherdemo.db.entity.CitiesForSearchEntity
import com.openweatherdemo.db.entity.CurrentWeatherEntity
import com.openweatherdemo.db.entity.ForecastEntity
import com.openweatherdemo.utils.typeconverters.DataConverter

@Database(
    entities = [
        ForecastEntity::class,
        CurrentWeatherEntity::class,
        CitiesForSearchEntity::class
    ],
    version = 2
)
@TypeConverters(DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    abstract fun currentWeatherDao(): CurrentWeatherDao

    abstract fun citiesForSearchDao(): CitiesForSearchDao
}
