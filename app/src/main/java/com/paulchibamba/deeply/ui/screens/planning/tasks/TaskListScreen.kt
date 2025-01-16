package com.paulchibamba.deeply.ui.screens.planning.tasks

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.paulchibamba.deeply.R
import com.paulchibamba.deeply.utils.SearchAppBarState
import com.paulchibamba.deeply.viewmodel.SharedViewModel

@Composable
fun TaskListScreen(
    navigateToTaskDetailScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchText: String by sharedViewModel.searchText
    Scaffold(
        topBar = {
            TaskListAppBar(sharedViewModel, searchAppBarState, searchText)
        },
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
fun TaskListFab(onFabClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(onClick = {
            onFabClicked(-1)
        }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task)
        )
    }
}