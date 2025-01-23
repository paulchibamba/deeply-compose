package com.paulchibamba.deeply.ui.screens.plan.projects

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulchibamba.deeply.data.repository.ProjectRepository
import com.paulchibamba.deeply.model.Project
import com.paulchibamba.deeply.utils.RequestState
import com.paulchibamba.deeply.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectRepository: ProjectRepository
) : ViewModel() {

    private val _searchAppBarState = mutableStateOf(SearchAppBarState.CLOSED)
    val searchAppBarState: State<SearchAppBarState> = _searchAppBarState

    private val _searchText = mutableStateOf("")
    val searchText: State<String> = _searchText

    private val _allProjects = MutableStateFlow<RequestState<List<Project>>>(RequestState.Idle)
    val allProjects: StateFlow<RequestState<List<Project>>> = _allProjects

    fun getAllProjects() {
        _allProjects.value = RequestState.Loading
        try {
            viewModelScope.launch {
                projectRepository.allProjects.collect {
                    _allProjects.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allProjects.value = RequestState.Error(e)
        }
    }

    fun updateSearchState(state: SearchAppBarState) {
        _searchAppBarState.value = state
    }

    fun updateSearchText(text: String) {
        _searchText.value = text
    }
}