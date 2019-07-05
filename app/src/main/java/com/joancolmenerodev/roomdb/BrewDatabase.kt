package com.joancolmenerodev.roomdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by joancolmenero on 05,July,2019
 **/
@Database(entities = [BrewSearched::class], version = 1)
abstract class BrewDatabase : RoomDatabase() {

    abstract fun brewSearched(): BrewSearched

    companion object {

        @Volatile private var INSTANCE: BrewDatabase? = null

        fun getInstance(context: Context): BrewDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                BrewDatabase::class.java, "Sample_db")
                .allowMainThreadQueries()
                .build()
    }

    abstract fun brewDao() : BrewDao
}