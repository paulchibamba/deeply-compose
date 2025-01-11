package com.paulchibamba.deeply.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulchibamba.deeply.data.repository.TaskRepository
import com.paulchibamba.deeply.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val taskRepository: TaskRepository): ViewModel() {

    private val _allTasks = MutableStateFlow<List<Task>>(emptyList())
    val allTasks: StateFlow<List<Task>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            taskRepository.allTasks.collect{
                _allTasks.value = it
            }
        }
    }
}