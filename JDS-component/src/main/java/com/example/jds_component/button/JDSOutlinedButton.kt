package com.example.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun JDSOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (enabled) JDSColor.MAIN else JDSColor.GRAY1,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .background(
                color = JDSColor.WHITE,
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
            color = if (enabled) JDSColor.MAIN else JDSColor.GRAY2,
            style = JDSTypography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun JDSOutlinedButtonPreview() {
    Column {
        JDSOutlinedButton(text = "text", enabled = true, onClick = {})
        JDSOutlinedButton(text = "text", enabled = false, onClick = {})
    }
}