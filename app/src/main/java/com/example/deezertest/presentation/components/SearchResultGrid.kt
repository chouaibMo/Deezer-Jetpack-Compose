package com.example.deezertest.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.Artist

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchResultGrid(artists: List<Artist>, onClick : (Int) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(top = 10.dp),
    ) {
        itemsIndexed(items = artists) { _, artist ->
            SearchResultItem(artist = artist) {
                onClick(artist.id)
            }
        }
    }
}