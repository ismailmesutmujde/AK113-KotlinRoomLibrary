package com.ismailmesutmujde.kotlinroomlibrary.dao

import androidx.room.Dao
import androidx.room.Query
import com.ismailmesutmujde.kotlinroomlibrary.model.Persons

@Dao
interface PersonsDao {

    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>
}