package com.learn.android.simplereminder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.learn.android.simplereminder.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Scaffold() { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
        ) {
            Text(
                text = stringResource(R.string.homescreen_title)
            )
        }
    }
}