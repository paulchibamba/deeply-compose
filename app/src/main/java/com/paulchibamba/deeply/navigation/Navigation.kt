package com.paulchibamba.deeply.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.paulchibamba.deeply.navigation.destinations.projects.projectDetailComposable
import com.paulchibamba.deeply.navigation.destinations.projects.projectListComposable
import com.paulchibamba.deeply.navigation.destinations.tasks.taskDetailComposable
import com.paulchibamba.deeply.navigation.destinations.tasks.taskListComposable
import com.paulchibamba.deeply.ui.screens.plan.projects.ProjectViewModel
import com.paulchibamba.deeply.utils.Constants.PROJECT_LIST_SCREEN
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_SCREEN
import com.paulchibamba.deeply.viewmodel.SharedViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    projectViewModel: ProjectViewModel
) {
    val screen = remember(navController){
        Screens(navController = navController)
    }
    
    NavHost(
        navController = navController,
        startDestination = TASK_LIST_SCREEN
    ){
        taskListComposable(
            navigateToTaskDetailScreen = screen.taskDetail,
            sharedViewModel = sharedViewModel
        )
        taskDetailComposable(
            navigateToTaskListScreen = screen.taskList
        )
        projectListComposable(
            navigateToProjectDetailScreen = screen.projectDetail,
            projectViewModel = projectViewModel
        )
        projectDetailComposable(
            navigateToProjectListScreen = screen.projectList
        )

    }
}