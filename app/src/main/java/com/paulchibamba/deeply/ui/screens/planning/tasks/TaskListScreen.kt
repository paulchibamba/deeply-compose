package com.paulchibamba.deeply.ui.screens.planning.tasks

import android.content.ContentValues.TAG
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.paulchibamba.deeply.R

@Composable
fun TaskListScreen(
    navigateToTaskDetailScreen: (Int) -> Unit
){
    Scaffold(
        content = {
            Log.d(TAG, "ListScreen: $it")
        },
        floatingActionButton = {
            TaskListFab(
                onFabClicked = navigateToTaskDetailScreen
            )
        }
    )
}

@Composable
fun TaskListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(onClick = {
            onFabClicked(-1)
        }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task)
        )
    }
}


@Preview()
@Composable
fun TaskListScreenPreview(){
    TaskListScreen(navigateToTaskDetailScreen = {})
}