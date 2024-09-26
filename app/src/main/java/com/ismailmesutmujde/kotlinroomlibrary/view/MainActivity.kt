package com.ismailmesutmujde.kotlinroomlibrary.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinroomlibrary.R
import com.ismailmesutmujde.kotlinroomlibrary.dao.PersonsDao
import com.ismailmesutmujde.kotlinroomlibrary.database.DatabaseAccess
import com.ismailmesutmujde.kotlinroomlibrary.model.Persons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var db:DatabaseAccess
    private lateinit var pdao:PersonsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseAccess.databaseAccess(this)!!
        pdao = db.getPersonsDao()

        //insertPerson()
        //updatePerson()
        //deletePerson()
        //loadingPersons()
        //bringRandom1Person()
        //searchPerson()
        bringPerson()
    }

    fun loadingPersons() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personsList = pdao.allPersons()

            for(p in personsList) {
                Log.e("Person id", p.person_id.toString())
                Log.e("Person name", p.person_name)
                Log.e("Person age", p.person_age.toString())
            }
        }
    }

    fun insertPerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,"Mehmet",75)
            pdao.insertPerson(newPerson)
        }
    }

    fun updatePerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(6,"Mehmet",75)
            pdao.updatePerson(updatedPerson)
        }
    }

    fun deletePerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(3,"New Ahmet",50)
            pdao.deletePerson(deletedPerson)
        }
    }

    fun bringRandom1Person() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val incomingList = pdao.bringRandom1Person()
            for(p in incomingList) {
                Log.e("Person id", p.person_id.toString())
                Log.e("Person name", p.person_name)
                Log.e("Person age", p.person_age.toString())
            }
        }
    }

    fun searchPerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personList = pdao.searchPerson("e")
            for(p in personList) {
                Log.e("Person id", p.person_id.toString())
                Log.e("Person name", p.person_name)
                Log.e("Person age", p.person_age.toString())
            }
        }
    }

    fun bringPerson() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val incomingPerson = pdao.bringPerson(4)
            Log.e("Person id", incomingPerson.person_id.toString())
            Log.e("Person name", incomingPerson.person_name)
            Log.e("Person age", incomingPerson.person_age.toString())
        }
    }
}