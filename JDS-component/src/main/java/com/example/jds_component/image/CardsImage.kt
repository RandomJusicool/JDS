package com.example.jds_component.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jds_component.R

@Composable
fun CardsImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.cards_image),
        contentDescription = null,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun Preview() {
    CardsImage()
}