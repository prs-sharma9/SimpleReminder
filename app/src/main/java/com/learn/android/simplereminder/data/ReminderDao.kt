package com.learn.android.simplereminder.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.learn.android.simplereminder.data.model.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderDao {

    @Insert
    suspend fun insert(reminder: Reminder): Long

    @Delete
    suspend fun delete(reminder: Reminder)

    @Query("SELECT * FROM reminder")
    fun getAll(): Flow<List<Reminder>>

    @Update
    suspend fun update(reminder: Reminder)

}