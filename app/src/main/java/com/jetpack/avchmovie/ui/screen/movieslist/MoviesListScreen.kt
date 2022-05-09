package com.jetpack.avchmovie.ui.screen.movieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.jetpack.avchmovie.R
import com.jetpack.avchmovie.common.Constants
import com.jetpack.avchmovie.data.model.Result

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesListScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ) {
            state.data?.let {
                items(it.results) { results ->
                    MovieWidget(results)
                }
            }
        }
    }
}

@Composable
fun MovieWidget(result: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 5.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                contentDescription = result.name,
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("${Constants.POSTER_BASE_URL}${result.posterPath}")
                        .crossfade(true)
                        .transformations(RoundedCornersTransformation(10f))
                        .placeholder(R.drawable.poster_large)
                        .build()
                )
            )
            Column(modifier = Modifier.padding(5.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(imageVector = Icons.Default.Star, tint = Color.Yellow, contentDescription = "vote average")
                    Text(text = result.voteAverage.toString(), style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(imageVector = Icons.Outlined.Person, contentDescription = "vote count")
                    Text(text = result.voteCount.toString(), style = MaterialTheme.typography.caption)
                }
                result.name?.let { Text(text = it, style = MaterialTheme.typography.caption) }
            }
        }
    }
}
