package com.learn.android.simplereminder.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.learn.android.simplereminder.R
import com.learn.android.simplereminder.components.MyAppBar
import com.learn.android.simplereminder.components.ReminderListItem
import com.learn.android.simplereminder.data.model.getDefaultReminder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            MyAppBar(
                title = stringResource(R.string.homescreen_title)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
        ) {
            ReminderListItem(
                reminder = getDefaultReminder(),
                onEdit = {
                    Log.d("Preview_ReminderListItem", "Edit test reminder")
                },
                onDelete = {
                    Log.d("Preview_ReminderListItem", "Delete test reminder")
                },
                onClick = {
                    Log.d("Preview_ReminderListItem", "Show test reminder")
                })
        }
    }
}