package com.paulchibamba.deeply.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.paulchibamba.deeply.navigation.destinations.tasks.taskDetailComposable
import com.paulchibamba.deeply.navigation.destinations.tasks.taskListComposable
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController, ){
    val screen = remember(navController){
        Screens(navController = navController)
    }
    
    NavHost(
        navController = navController,
        startDestination = TASK_LIST_SCREEN
    ){
        taskListComposable(
            navigateToTaskDetailScreen = screen.taskDetail
        )
        taskDetailComposable(
            navigateToTaskListScreen = screen.taskList
        )
    }
}