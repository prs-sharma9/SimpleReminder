package com.learn.android.simplereminder.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.learn.android.simplereminder.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String,
    enableBack: Boolean = false,
    backIcon: @Composable (() -> Unit) = {},
    onBack: () -> Unit = {},
    enableAction: Boolean = false,
    actionIcon: @Composable (() -> Unit) = {},
    onAction: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        navigationIcon = {
            if(enableBack) {
                IconButton(onClick = onBack) {
                    backIcon()
                }
            }
        },
        actions = {
            if(enableAction) {
                IconButton(
                    onClick = onAction
                ) {
                    actionIcon()
                }
            }
        }
    )
}