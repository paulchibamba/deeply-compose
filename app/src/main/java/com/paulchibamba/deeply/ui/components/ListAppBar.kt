package com.paulchibamba.deeply.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.paulchibamba.deeply.R
import com.paulchibamba.deeply.model.Priority
import com.paulchibamba.deeply.ui.theme.MEDIUM_PADDING
import com.paulchibamba.deeply.utils.SearchAppBarState

@Composable
fun ListAppBar(
    title: String,
    searchAppBarState: SearchAppBarState,
    searchText: String,
    onSearchStateChange: (SearchAppBarState) -> Unit,
    onSearchTextChange: (String) -> Unit,
    onSortClicked: (Priority) -> Unit = {},
    onDeleteAllClicked: () -> Unit = {}
){
    when (searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                title = title,
                onSearchClicked = { onSearchStateChange(SearchAppBarState.OPENED) },
                onSortClicked = onSortClicked,
                onDeleteAllCLicked = onDeleteAllClicked
            )
        }
        else -> {
            SearchAppBar(
                text = searchText,
                onTextChange = { onSearchTextChange(it) },
                onCloseClicked = {
                    onSearchStateChange(SearchAppBarState.CLOSED)
                    onSearchTextChange("")
                },
                onSearchClicked = {}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    title: String,
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllCLicked: () -> Unit
){
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = { ListAppBarActions(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    TopAppBar(
        title = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = text,
                onValueChange = { onTextChange(it) },
                placeholder = {
                    Text(
                        modifier = Modifier.alpha(0.5f),
                        text = stringResource(R.string.search_placeholder),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(
                        onClick = { onCloseClicked() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.search_icon),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { onTextChange("") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_clear_24),
                                contentDescription = stringResource(R.string.close_icon),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClicked(text)
                    }
                )
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Composable
fun ListAppBarActions(
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
fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        title = "Projects",
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteAllCLicked = {}
    )
}

@Preview
@Composable
fun SearchAppBarPreview(){
    SearchAppBar(
        text = "Search...",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}