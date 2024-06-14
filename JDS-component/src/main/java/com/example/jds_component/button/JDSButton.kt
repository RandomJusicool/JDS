package com.example.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    textColor: Color = JDSColor.WHITE,
    backgroundColor: Color = JDSColor.MAIN,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(
                color = backgroundColor,
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
            color = textColor,
            style = JDSTypography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun JDSButtonPreview() {
    Column {
        JDSButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = true,
            onClick = {}
        )
        JDSButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = false,
            onClick = {}
        )
        JDSButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = true,
            textColor = JDSColor.SYSTEM,
            backgroundColor = JDSColor.MAIN,
            onClick = {}
        )
        JDSButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = false,
            textColor = JDSColor.SYSTEM,
            backgroundColor = JDSColor.MAIN,
            onClick = {}
        )
    }
}