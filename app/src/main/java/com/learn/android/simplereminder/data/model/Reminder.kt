package com.learn.android.simplereminder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val timeInMills: Long,
    val isCompleted: Boolean = false
)


fun getDefaultReminder(): Reminder {
    return Reminder(
        title = "Test Reminder",
        description = "This is a test reminder to test the UI functionality. It should not be used in any of the production code. Making this text long to test the UI issues related to long description text. Max 3 lines are allowed to be displayed in the reminder list screen.",
        timeInMills = System.currentTimeMillis() + (60*60*5)
    )
}