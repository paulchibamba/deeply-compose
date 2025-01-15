package com.paulchibamba.deeply.navigation.destinations.tasks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.deeply.ui.screens.planning.tasks.TaskListScreen
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_KEY
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_SCREEN

fun NavGraphBuilder.taskListComposable(navigateToTaskDetailScreen: (taskId: Int) -> Unit){
    composable(
        route = TASK_LIST_SCREEN,
        arguments = listOf(navArgument(TASK_LIST_KEY){
            type = NavType.StringType
        })
    ){
        TaskListScreen(navigateToTaskDetailScreen = navigateToTaskDetailScreen)
    }

}