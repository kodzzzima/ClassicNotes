package com.example.notes.database

import androidx.lifecycle.LiveData
import com.example.notes.models.AppNote

interface DataBaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote,onSuccess:() -> Unit)
    suspend fun delete(note: AppNote,onSuccess:() -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String)-> Unit){}

    fun signOut(){}
}