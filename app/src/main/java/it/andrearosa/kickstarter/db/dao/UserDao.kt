package it.andrearosa.kickstarter.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import it.andrearosa.kickstarter.db.models.UserModel

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserModel>

    @Insert(onConflict = REPLACE)
    fun insert(user: UserModel)

    @Query("DELETE from users")
    fun deleteAll()
}