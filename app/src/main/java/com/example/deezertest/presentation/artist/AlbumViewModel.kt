package com.example.deezertest.presentation.artist

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deezertest.navigation.ARG_ARTIST_ID
import com.example.domain.usecase.ArtistAlbumUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Artist viewModel, providing [AlbumUiState] and methods for [AlbumScreen].
 */
@HiltViewModel
class AlbumViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val artistAlbumUseCase: ArtistAlbumUseCase,
) : ViewModel() {

    private var mediaPlayer: MediaPlayer? = null
    private var playingPreview: String? = null

    private val artistId: Int = checkNotNull(savedStateHandle[ARG_ARTIST_ID])

    var uiState: MutableStateFlow<AlbumUiState> = MutableStateFlow(AlbumUiState())

    init {
        viewModelScope.launch {
            val album = artistAlbumUseCase.getArtistFirstAlbum(artistId)
            uiState.value = uiState.value.copy(album = album)
        }
    }

    /**
     * Play the [preview] of stop it if it's already playing.
     */
    fun playPreviewRequest(context: Context, preview: String) {
        mediaPlayer?.let {
            if(it.isPlaying){
                stopPlayer()
            }
            if(preview != playingPreview) {
                playingPreview = preview
                mediaPlayer = MediaPlayer.create(context, Uri.parse(preview))
                mediaPlayer?.start()
            }
        } ?: run {
            playingPreview = preview
            mediaPlayer = MediaPlayer.create(context, Uri.parse(preview))
            mediaPlayer?.start()
        }
    }

    /**
     * Stop the media player.
     */
    fun stopPlayer() {
        mediaPlayer?.let {
            it.stop()
            it.reset()
        }
        mediaPlayer = null
    }

}