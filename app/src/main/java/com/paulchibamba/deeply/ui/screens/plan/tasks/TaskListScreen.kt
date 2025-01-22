package com.paulchibamba.deeply.ui.screens.plan.tasks

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.paulchibamba.deeply.R
import com.paulchibamba.deeply.utils.SearchAppBarState
import com.paulchibamba.deeply.viewmodel.SharedViewModel


@Composable
fun TaskListScreen(
    navigateToTaskDetailScreen: (taskId: Long) -> Unit,
    sharedViewModel: SharedViewModel
){
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTasks()
    }

    val allTasks by sharedViewModel.allTasks.collectAsState()
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchText: String by sharedViewModel.searchText
    Scaffold(
        topBar = {
            TaskListAppBar(sharedViewModel, searchAppBarState, searchText)
        },
        content = {paddingValues ->
            TaskListContent(
                tasks = allTasks,
                navigateToTaskDetail = navigateToTaskDetailScreen,
                modifier = Modifier.padding(paddingValues)
            )

        },
        floatingActionButton = {
            TaskListFab(
                onFabClicked = navigateToTaskDetailScreen
            )
        }
    )
}

@Composable
fun TaskListFab(onFabClicked: (taskId: Long) -> Unit) {
    FloatingActionButton(onClick = {
            onFabClicked(-1)
        }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task)
        )
    }
}