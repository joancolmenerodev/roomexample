package com.joancolmenerodev.roomdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by joancolmenero on 05,July,2019
 **/
@Entity(tableName = "brewsearched")
data class BrewSearched (
    @PrimaryKey
    @ColumnInfo(name = "food")
    var food: String
){
    constructor(): this("")
}