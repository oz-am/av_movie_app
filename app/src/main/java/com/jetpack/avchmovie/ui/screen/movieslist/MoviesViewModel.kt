package com.jetpack.avchmovie.ui.screen.movieslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.avchmovie.common.MutableState
import com.jetpack.avchmovie.common.Resource
import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.repository.protocole.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _state = mutableStateOf(MutableState<MovieResult>())
    val state: State<MutableState<MovieResult>> = _state

    init {
        repository.getMovies(1).onEach { result ->
            when (result) {
                is Resource.Success -> { _state.value = MutableState(data = result.data) }
                is Resource.Error -> { _state.value = MutableState(error = result.message ?: "An unexpected error occured") }
                is Resource.Loading -> { _state.value = MutableState(isLoading = true) }
            }
        }.launchIn(viewModelScope)
    }
}
