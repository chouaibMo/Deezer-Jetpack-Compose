package com.example.deezertest.presentation.artist

import com.example.domain.model.Album

/**
 * Data class that defines the ui state of [AlbumScreen]
 */
data class AlbumUiState(
    /**
     * Whether the content is loading.
     */
    var isLoading: Boolean = false,

    /**
     * Selected [Album].
     */
    var album: Album? = null,
)