package com.example.deezertest.presentation.artist

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Downloading
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.deezertest.util.releaseYearDisplay
import com.example.domain.model.Album

@Composable
fun AlbumScreen(navController: NavController, viewModel: AlbumViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()
    val context = LocalContext.current

    BackHandler {
        viewModel.stopPlayer()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        AlbumAppBar(context = context){
            viewModel.stopPlayer()
            navController.popBackStack()
        }
        AlbumHeader(album = uiState.value.album)
        TrackList(context = context, album = uiState.value.album) {
            viewModel.playPreviewRequest(context = context, preview = it)
        }
    }

}


@Composable
fun AlbumAppBar(context: Context, onBackClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "navigate back",
                tint = MaterialTheme.colors.primary
            )
        }
        IconButton(onClick = {
            Toast.makeText(context, "Download album starting ...", Toast.LENGTH_SHORT).show()
        }) {
            Icon(
                imageVector = Icons.Default.Downloading,
                contentDescription = "Download album",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun AlbumHeader(album: Album?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(album?.coverMedium),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .padding(start = 8.dp, bottom = 4.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = album?.title ?: "",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            text = album?.label ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.alpha(0.4f)
        )
        Text(
            text = "${album?.releaseDate?.releaseYearDisplay()} • ${album?.fans} fan",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.alpha(0.4f)
        )
    }
}