package com.paulchibamba.deeply.navigation.destinations.projects

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.deeply.ui.screens.plan.projects.ProjectListScreen
import com.paulchibamba.deeply.ui.screens.plan.projects.ProjectViewModel
import com.paulchibamba.deeply.utils.Constants

fun NavGraphBuilder.projectListComposable(
    navigateToProjectDetailScreen: (taskId: Long) -> Unit,
    projectViewModel: ProjectViewModel
){
    composable(
        route = Constants.PROJECT_LIST_SCREEN,
        arguments = listOf(navArgument(Constants.LIST_KEY){
            type = NavType.StringType
        })
    ){
        ProjectListScreen(navigateToProjectDetailScreen, projectViewModel)
    }

}