package com.paulchibamba.deeply.ui.screens.planning.tasks

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.paulchibamba.deeply.R
import com.paulchibamba.deeply.model.Priority
import com.paulchibamba.deeply.ui.components.PriorityItem
import com.paulchibamba.deeply.ui.theme.MEDIUM_PADDING

@Composable
fun TaskListAppBar(){
    DefaultTaskListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteAllCLicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTaskListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllCLicked: () -> Unit
){
    TopAppBar(
        title = { Text(text = "Tasks") },
        actions = { TaskListAppBarActions(
            onSearchClicked,
            onSortClicked,
            onDeleteAllCLicked
        ) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Composable
fun TaskListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllCLicked: () -> Unit
){
    SearchAction(onSearchClicked)
    SortAction(onSortClicked)
    MoreAction(onDeleteAllCLicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(
        onClick = { onSearchClicked() }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_icon),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list_24),
            contentDescription = stringResource(R.string.sort_icon),
            tint = MaterialTheme.colorScheme.onSurface
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.LOW)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.LOW)
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.HIGH)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.HIGH)
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.NONE)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.NONE)
                }
            )
            
        }
        
    }
}

@Composable
fun MoreAction(
    onDeleteAllTasksCLicked: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_more_vert_24),
            contentDescription = stringResource(R.string.more_options_icon),
            tint = MaterialTheme.colorScheme.onSurface
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteAllTasksCLicked()
                },
                text = {
                    Text(
                        modifier = Modifier.padding(start = MEDIUM_PADDING),
                        text = stringResource(R.string.delete_all_tasks),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun DefaultTaskListAppBarPreview(){
    DefaultTaskListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteAllCLicked = {}
    )
}