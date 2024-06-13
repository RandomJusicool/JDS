package com.example.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jds_component.color.JDS
import com.example.jds_component.modifier.clickableSingle.clickableSingle
import com.example.jds_component.typography.JDSTypography


@Composable
fun JDSButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = if (enabled) JDS.MAIN else JDS.GRAY300,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .clickableSingle(
                enabled = enabled,
                onClick = onClick,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = if (enabled) JDS.WHITE else JDS.GRAY600,
            style = JDSTypography.bodyMedium,
        )
    }
}