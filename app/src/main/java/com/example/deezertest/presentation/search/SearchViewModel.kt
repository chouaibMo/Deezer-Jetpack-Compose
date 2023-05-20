package com.example.deezertest.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ArtistSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Search viewModel, providing [SearchUiState] and methods for [SearchScreen].
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val artisteSearchUseCase: ArtistSearchUseCase
) : ViewModel() {

    /**
     * Stateflow of [SearchUiState].
     */
    var searchUiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())

    /**
     * Search job.
     */
    private var searchJob: Job? = null

    // FIXME : for demo purpose only - should be removed.
    var popularFRUiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())
    var popularUSUiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())

    // FIXME : for demo purpose only - should be removed.
    init {
        val popularFRArtists = listOf(58624, 390, 5542343, 4448630, 310260, 1042268)
        val popularUSArtists = listOf(13, 564, 4495513, 167095, 246791)
        viewModelScope.launch {
            val artistsFR = popularFRArtists.mapNotNull { artisteSearchUseCase.getArtist(it) }
            val artistsUS = popularUSArtists.mapNotNull { artisteSearchUseCase.getArtist(it) }
            popularFRUiState.value = popularFRUiState.value.copy(artists = artistsFR)
            popularUSUiState.value = popularUSUiState.value.copy(artists = artistsUS)
        }

    }

    /**
     * Handle a search request for [query] keyword.
     */
    fun searchRequested(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500)
            if(query.isNotBlank())
                searchByQuery(query)
        }
    }

    /**
     * Search for [Artist] matching [query].
     */
    private suspend fun searchByQuery(query: String) {
        val result = artisteSearchUseCase.getArtistsByQuery(query)
        searchUiState.value = searchUiState.value.copy(isLoading = false, artists = result)

    }
}