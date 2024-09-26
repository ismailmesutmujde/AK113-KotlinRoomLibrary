package com.ismailmesutmujde.kotlinroomlibrary.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinroomlibrary.R
import com.ismailmesutmujde.kotlinroomlibrary.dao.PersonsDao
import com.ismailmesutmujde.kotlinroomlibrary.database.DatabaseAccess
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

        loadingPersons()

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
}