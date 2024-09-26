package com.ismailmesutmujde.kotlinroomlibrary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinroomlibrary.R
import com.ismailmesutmujde.kotlinroomlibrary.dao.PersonsDao
import com.ismailmesutmujde.kotlinroomlibrary.database.DatabaseAccess


class MainActivity : AppCompatActivity() {

    private lateinit var db:DatabaseAccess
    private lateinit var pdao:PersonsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseAccess.databaseAccess(this)!!
        pdao = db.getPersonsDao()

    }
}