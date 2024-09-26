package com.ismailmesutmujde.kotlinroomlibrary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ismailmesutmujde.kotlinroomlibrary.dao.PersonsDao
import com.ismailmesutmujde.kotlinroomlibrary.model.Persons

@Database(entities = [Persons::class], version = 1)
abstract class DatabaseAccess : RoomDatabase() {
    abstract fun getPersonsDao() : PersonsDao
    
    companion object {
        var INSTANCE:DatabaseAccess? = null
        fun databaseAccess(context: Context) : DatabaseAccess? {
            if (INSTANCE == null) {
                synchronized(DatabaseAccess::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DatabaseAccess::class.java,
                        "guide.sqlite")
                        .createFromAsset("guide.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}