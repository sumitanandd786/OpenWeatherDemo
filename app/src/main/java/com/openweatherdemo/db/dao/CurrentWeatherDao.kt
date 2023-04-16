package com.openweatherdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.openweatherdemo.db.entity.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {

    @Query("SELECT * FROM CurrentWeather")
    fun getCurrentWeather(): LiveData<CurrentWeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Transaction
    fun deleteAndInsert(currentWeatherEntity: CurrentWeatherEntity) {
        deleteCurrentWeather()
        insertCurrentWeather(currentWeatherEntity)
    }

    @Query("DELETE FROM CurrentWeather")
    fun deleteCurrentWeather()

    @Query("Select count(*) from CurrentWeather")
    fun getCount(): Int
}
