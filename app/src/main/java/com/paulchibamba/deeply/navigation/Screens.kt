package com.paulchibamba.deeply.navigation

import androidx.navigation.NavHostController
import com.paulchibamba.deeply.utils.Action
import com.paulchibamba.deeply.utils.Constants.TASK_LIST_SCREEN

class Screens(navController: NavHostController) {
    val taskList: (Action) -> Unit = { action ->
        navController.navigate("task_list/${action.name}") {
            popUpTo(TASK_LIST_SCREEN) { inclusive = true }

        }
    }

    val taskDetail: (Int) -> Unit = { taskId ->
        navController.navigate("task_detail/$taskId")
    }
}