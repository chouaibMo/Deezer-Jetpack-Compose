package com.example.deezertest.presentation.search

import com.example.domain.model.Artist

/**
 * Data class that defines the ui state of [SearchScreen]
 */
data class SearchUiState(
    /**
     * Whether the content is loading.
     */
    var isLoading: Boolean = false,

    /**
     * list of [Artist].
     */
    var artists: List<Artist> = emptyList()
)