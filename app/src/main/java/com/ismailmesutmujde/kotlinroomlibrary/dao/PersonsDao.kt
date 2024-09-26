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

    @Query("SELECT * FROM persons WHERE person_name like '%' || :searchingWord || '%'")
    suspend fun searchPerson(searchingWord:String) : List<Persons>

    @Query("SELECT * FROM persons WHERE person_id=:person_id")
    suspend fun bringPerson(person_id:Int) : Persons

    @Query("SELECT count(*) FROM persons WHERE person_name=:person_name")
    suspend fun recordControl(person_name:String) : Int
}