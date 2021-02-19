package com.example.notes.database.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.notes.models.AppNote

@Database(entities = [AppNote::class],version = 1)
abstract class AppRoomDataBase:RoomDatabase() {
    abstract fun getAppRoomDao():AppRoomDao

    companion object{

        @Volatile
        private var database:AppRoomDataBase?=null

        @Synchronized
        fun getInstance(context: Context):AppRoomDataBase{
            return if (database==null){
                database = Room.databaseBuilder(
                    context,
                    AppRoomDataBase::class.java,
                    "database"
                ).fallbackToDestructiveMigration()
                    .build()
                database as AppRoomDataBase
            } else database as AppRoomDataBase
        }
    }
}