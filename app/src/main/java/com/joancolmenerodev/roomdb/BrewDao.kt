package com.joancolmenerodev.roomdb

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by joancolmenero on 05,July,2019
 **/
@Dao
interface BrewDao {

    @Query("SELECT * FROM brewsearched WHERE food = :id")
    fun getFoodById(id: String): Single<BrewSearched>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(food: BrewSearched): Completable

    fun getAllBrews() : List<BrewSearched>

}