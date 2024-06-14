package com.example.jds_component.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jds_component.R

@Composable
fun RightArrowIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = R.drawable.right_arrow_icon),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = tint
    )
}


@Preview
@Composable
private fun Preview(){
    RightArrowIcon()
}