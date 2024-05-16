package com.example.preferencedatastore


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class MyDataStoreManager(private val context : Context){
    val Context.datastore by preferencesDataStore(name = "myprefs")
    val NAME = stringPreferencesKey("name")

    suspend fun SaveName(name:String){
        context.datastore.edit {
            it[NAME] = name
        }
    }

    suspend fun GetName() : String{
        var dataFlow = context.datastore.data.map {
            it[NAME]
        }
        return dataFlow.first() ?: "Guest"
    }
}