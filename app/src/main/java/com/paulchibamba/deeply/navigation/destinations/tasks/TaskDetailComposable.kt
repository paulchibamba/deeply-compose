package com.paulchibamba.deeply.navigation.destinations.tasks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.deeply.utils.Action
import com.paulchibamba.deeply.utils.Constants.TASK_DETAIL_KEY
import com.paulchibamba.deeply.utils.Constants.TASK_DETAIL_SCREEN

fun NavGraphBuilder.taskDetailComposable(navigateToTaskListScreen: (Action) -> Unit){
    composable(
        route = TASK_DETAIL_SCREEN,
        arguments = listOf(navArgument(TASK_DETAIL_KEY){
            type = NavType.IntType
        })
    ){

    }

}