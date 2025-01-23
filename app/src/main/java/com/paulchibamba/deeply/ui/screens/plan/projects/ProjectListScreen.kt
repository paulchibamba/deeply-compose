package com.paulchibamba.deeply.ui.screens.plan.projects

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
import com.paulchibamba.deeply.ui.components.ListAppBar
import com.paulchibamba.deeply.utils.SearchAppBarState

@Composable
fun ProjectListScreen(
    navigateToProjectDetailScreen: (taskId: Long) -> Unit,
    projectViewModel: ProjectViewModel
){
    LaunchedEffect(key1 = true) {
        projectViewModel.getAllProjects()
    }

    val allProjects by projectViewModel.allProjects.collectAsState()
    val searchAppBarState: SearchAppBarState by projectViewModel.searchAppBarState
    val searchText: String by projectViewModel.searchText


    Scaffold(
        topBar = {
            ListAppBar(
                title = stringResource(R.string.projects),
                searchAppBarState = searchAppBarState,
                searchText = searchText,
                onSearchStateChange = { projectViewModel.updateSearchState(it) },
                onSearchTextChange = { projectViewModel.updateSearchText(it) },
                onDeleteAllClicked = {  }
            )
        },
        content = { paddingValues ->
            ProjectListContent(
                projects = allProjects,
                navigateToProjectDetailScreen = navigateToProjectDetailScreen,
                modifier = Modifier.padding(paddingValues)
            )
        },
        floatingActionButton = {
            ProjectListFab(onFabClicked = navigateToProjectDetailScreen)
        }
    )
}

@Composable
fun ProjectListFab(onFabClicked: (taskId: Long) -> Unit) {
    FloatingActionButton(onClick = {
        onFabClicked(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_project)
        )
    }
}


