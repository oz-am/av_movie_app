package com.jetpack.avchmovie.ui.screen.moviedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.jetpack.avchmovie.R
import com.jetpack.avchmovie.ui.screen.movieslist.MoviesViewModel

@Preview
@Composable
fun MovieDetailScreen(viewModel: MoviesViewModel = hiltViewModel()) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 4.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded),
            painter = painterResource(id = R.drawable.poster_large),
            contentScale = ContentScale.Crop,
            contentDescription = "poster"
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
                .background(Color.Black)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                contentDescription = "poster",
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.poster_large)
                        .crossfade(true)
                        .placeholder(R.drawable.poster_large)
                        .transformations(RoundedCornersTransformation(15f))
                        .build()
                )
            )

            // result.name?.let { Text(text = it, style = MaterialTheme.typography.caption) }
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "name",
                style = MaterialTheme.typography.h4,
                color = Color.White
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "Comedy Nights with Kapil is a comedy show which provides a distinctive take on the everyday life of a common man as the show explores the story of every household and how our common man Kapil is affected by the simplest issues in life around him.",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    }
}
