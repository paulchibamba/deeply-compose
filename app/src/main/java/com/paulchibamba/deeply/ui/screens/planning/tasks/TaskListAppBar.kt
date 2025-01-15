package com.paulchibamba.deeply.ui.screens.planning.tasks

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskListAppBar(){
    DefaultTaskListAppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTaskListAppBar(){
    TopAppBar(
        title = {
            Text(text = "Tasks")
        },
        actions = {/*TODO*/},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Preview
@Composable
fun DefaultTaskListAppBarPreview(){
    DefaultTaskListAppBar()
}