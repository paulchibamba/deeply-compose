package com.paulchibamba.deeply.navigation.destinations.projects

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.deeply.utils.Action
import com.paulchibamba.deeply.utils.Constants

fun NavGraphBuilder.projectDetailComposable(navigateToProjectListScreen: (Action) -> Unit){
    composable(
        route = Constants.PROJECT_DETAIL_SCREEN,
        arguments = listOf(navArgument(Constants.DETAIL_KEY){
            type = NavType.IntType
        })
    ){

    }

}