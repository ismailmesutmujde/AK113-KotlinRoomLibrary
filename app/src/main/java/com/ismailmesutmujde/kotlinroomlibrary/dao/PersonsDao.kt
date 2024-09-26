package com.ismailmesutmujde.kotlinroomlibrary.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ismailmesutmujde.kotlinroomlibrary.model.Persons

@Dao
interface PersonsDao {

    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>

    @Insert
    suspend fun insertPerson(person:Persons)

    @Update
    suspend fun updatePerson(person:Persons)

    @Delete
    suspend fun deletePerson(person:Persons)

    @Query("SELECT * FROM persons ORDER BY RANDOM() LIMIT 1")
    suspend fun bringRandom1Person() : List<Persons>
}