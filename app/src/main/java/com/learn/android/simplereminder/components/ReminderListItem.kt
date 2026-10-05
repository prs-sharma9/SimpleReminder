package com.learn.android.simplereminder.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.test.delete_forever
import com.learn.android.simplereminder.R
import com.learn.android.simplereminder.components.icons.edit_note
import com.learn.android.simplereminder.data.model.Reminder
import com.learn.android.simplereminder.data.model.getDefaultReminder

@Composable
fun ReminderListItem(
    modifier: Modifier = Modifier,
    reminder: Reminder,
    onEdit: (Int) -> Unit,
    onDelete: (Int) -> Unit,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = reminder.title,
                style = MaterialTheme.typography.headlineMedium,
                textDecoration = TextDecoration.Underline,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                maxLines = 3,
                text = reminder.description,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReminderCardActionButton(
                    icon = {
                        Icon(
                            imageVector = edit_note,
                            contentDescription = stringResource(R.string.edit_icon_description)
                        )
                    }
                ) {
                    onEdit(reminder.id)
                }

                ReminderCardActionButton(
                    icon = {
                        Icon(
                            imageVector = delete_forever,
                            contentDescription = stringResource(R.string.delete_icon_description)
                        )
                    }
                ) {
                    onDelete(reminder.id)
                }
            }
        }
    }
}

@Composable
fun ReminderCardActionButton(
    icon: @Composable (() -> Unit),
    onActionClicked: () -> Unit
) {
    IconButton(
        modifier = Modifier
            .border(
                width = Dp.Hairline,
                color = MaterialTheme.colorScheme.secondary,
                shape = CircleShape
            ),
        onClick = onActionClicked,
        shape = CircleShape,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        icon()
    }
}


@Preview
@Composable
fun Preview_ReminderListItem() {
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
        }
    )
}