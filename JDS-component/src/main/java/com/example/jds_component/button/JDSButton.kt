package com.example.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jds_component.color.JDSColor
import com.example.jds_component.modifier.clickableSingle.clickableSingle
import com.example.jds_component.typography.JDSTypography


@Composable
fun JDSButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = if (enabled) JDSColor.MAIN else JDSColor.GRAY300,
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
            color = if (enabled) JDSColor.WHITE else JDSColor.GRAY600,
            style = JDSTypography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun JDSButtonPreview() {
    Column {
        JDSButton(text = "text", enabled = true, onClick = {})
        JDSButton(text = "text", enabled = false, onClick = {})
    }
}