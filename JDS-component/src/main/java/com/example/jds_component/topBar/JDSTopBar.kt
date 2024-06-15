package com.example.jds_component.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jds_component.color.JDSColor
import com.example.jds_component.icon.LeftArrowIcon
import com.example.jds_component.icon.ProfileIcon
import com.example.jds_component.icon.SearchIcon
import com.example.jds_component.image.LogoImage
import com.example.jds_component.typography.JDSTypography

@Composable
fun JDSMainTopBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit,
    betweenIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) },
    endIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) },
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            startIcon()
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            betweenIcon()
            Spacer(modifier = Modifier.size(24.dp))
            endIcon()
        }
    }
}

@Composable
fun JDSTopBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit,
    betweenText: String = "",
    endIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            )
    ) {
        startIcon()
        Text(
            text = betweenText,
            style = JDSTypography.labelSmall,
            color = JDSColor.Black
        )
        endIcon()
    }
}

@Preview
@Composable
private fun JDSTopBarPreview() {
    Column {
        JDSMainTopBar(
            startIcon = { LogoImage() },
            betweenIcon = { SearchIcon() },
            endIcon = { ProfileIcon() }
        )
        JDSTopBar(
            startIcon = { LeftArrowIcon() },
            betweenText = "마이크로소프트"
        )
    }
}