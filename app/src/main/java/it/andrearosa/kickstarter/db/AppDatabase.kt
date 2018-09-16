package it.andrearosa.kickstarter.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import it.andrearosa.kickstarter.db.dao.UserDao
import it.andrearosa.kickstarter.db.models.UserModel

@Database(entities = [(UserModel::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "app_database.db")
                            .build()
                }
            }
            return INSTANCE
        }
    }

}