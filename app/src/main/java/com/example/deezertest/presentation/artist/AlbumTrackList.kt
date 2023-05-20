package com.example.deezertest.presentation.artist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Downloading
import androidx.compose.material.icons.outlined.Explicit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.deezertest.util.durationDisplay
import com.example.domain.model.Album
import com.example.domain.model.Track


@Composable
fun TrackList(context: Context, album: Album?, onPreviewPlayClick : (String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 10.dp),
    ) {
        item {
            album?.tracks?.forEach { track ->
                TrackItem(context, track, album.cover) {
                    onPreviewPlayClick(it)
                }
            }
        }
    }
}

@Composable
fun TrackItem(context: Context, track: Track, cover: String, onPreviewPlayClick : (String) -> Unit) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .clickable { onPreviewPlayClick(track.preview) },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(cover),
                    contentDescription = "Album cover",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Column(Modifier.padding(8.dp)) {
                    Text(
                        maxLines = 1,
                        text = track.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onSurface
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = track.duration.durationDisplay(),
                            color = MaterialTheme.colors.onBackground,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.alpha(0.4f),

                            )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(track.explicitLyrics){
                    Icon(
                        imageVector = Icons.Outlined.Explicit,
                        contentDescription = "Explicit",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp)
                    )
                }

                Icon(
                    imageVector = Icons.Outlined.Downloading,
                    contentDescription = "Download",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(20.dp)
                        .clickable {
                            Toast.makeText(context, "Download track starting ...", Toast.LENGTH_SHORT).show()
                        }
                )
            }
        }

    }
}