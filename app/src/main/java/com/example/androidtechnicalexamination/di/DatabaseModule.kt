package com.example.androidtechnicalexamination.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidtechnicalexamination.data.room.RoomDB
import com.example.androidtechnicalexamination.data.room.user.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application) : RoomDB {
        return Room.databaseBuilder(app, RoomDB::class.java, "Database.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                }
            })
            .build()
    }

    @Provides
    @Singleton
    fun providePersonDao(db: RoomDB) : UsersDao {
        return db.personDao()
    }
}