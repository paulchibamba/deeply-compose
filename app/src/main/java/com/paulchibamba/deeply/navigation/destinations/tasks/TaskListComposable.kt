package com.paulchibamba.deeply.navigation.destinations.tasks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.deeply.ui.screens.plan.tasks.TaskListScreen
import com.paulchibamba.deeply.utils.Constants.LIST_KEY
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_SCREEN
import com.paulchibamba.deeply.viewmodel.SharedViewModel

fun NavGraphBuilder.taskListComposable(
    navigateToTaskDetailScreen: (taskId: Long) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = TASK_LIST_SCREEN,
        arguments = listOf(navArgument(LIST_KEY){
            type = NavType.StringType
        })
    ){
        TaskListScreen(navigateToTaskDetailScreen, sharedViewModel)
    }

}