package com.example.deezertest.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CircleNotifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.deezertest.presentation.components.SearchResultGrid
import com.example.deezertest.presentation.components.SearchResultItem
import com.example.domain.model.Artist


@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel = hiltViewModel()) {
    val uiState = viewModel.searchUiState.collectAsState()
    val uiStatePopularFR = viewModel.popularFRUiState.collectAsState()
    val uiStatePopularUS = viewModel.popularUSUiState.collectAsState()
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        SearchScreenHeader()
        SearchBarSection {
            query = it
            viewModel.searchRequested(it)
        }

        if(query.isEmpty()) {
            Demo(navController = navController,
                popularFR = uiStatePopularFR.value.artists,
                popularUS = uiStatePopularUS.value.artists)
        }
        else {
            SearchResultGrid(artists = uiState.value.artists) {
                navController.navigate("artist/$it")
            }
        }
    }
}

@Composable
fun SearchScreenHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter("https://images.pexels.com/photos/2531553/pexels-photo-2531553.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.onSurface, CircleShape)
                    .clickable { }
            )
            Column(
                verticalArrangement = Arrangement.spacedBy((-4).dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = "Welcome back,",
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = "John Doe",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
        Icon(
            imageVector = Icons.Outlined.CircleNotifications,
            contentDescription = "Notifications",
            modifier = Modifier
                .size(28.dp)
                .clickable {}
        )
    }
}

// FIXME : for demo purpose only, should be removed.
@Composable
fun Demo(navController: NavController, popularFR : List<Artist>, popularUS : List<Artist>) {
    LazyColumn(
        modifier = Modifier.padding(end = 0.dp, top = 10.dp)
    ) {

        item {
            Text(
                text = "Popular artists in France",
                color = MaterialTheme.colors.onBackground,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        item {
            LazyRow(Modifier.padding(vertical = 10.dp)) {
                itemsIndexed(popularFR) { _, artist ->
                    SearchResultItem(artist = artist) {
                        navController.navigate("artist/${artist.id}")
                    }
                }
            }
        }


        item {
            Text(
                text = "Popular artists in USA",
                color = MaterialTheme.colors.onBackground,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        item {
            LazyRow(Modifier.padding(vertical = 10.dp)) {
                itemsIndexed(popularUS) { _, artist ->
                    SearchResultItem(artist = artist) {
                        navController.navigate("artist/${artist.id}")
                    }
                }
            }
        }
    }

}