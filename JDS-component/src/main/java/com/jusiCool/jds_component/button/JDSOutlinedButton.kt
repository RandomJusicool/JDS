package com.jusiCool.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.jusiCool.jds_component.color.JDSColor
import com.jusiCool.jds_component.modifier.clickableSingle.clickableSingle
import com.jusiCool.jds_component.typography.JDSTypography

@Composable
fun JDSOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = JDSColor.MAIN,
    borderColor: Color = JDSColor.MAIN,
    backgroundColor: Color = JDSColor.WHITE,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
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
fun JDSOutlinedButtonPreview() {
    Column {
        JDSOutlinedButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = true,
            onClick = {}
        )
        JDSOutlinedButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = false,
            onClick = {}
        )
        JDSOutlinedButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = true,
            textColor = JDSColor.ERROR,
            backgroundColor = JDSColor.MAIN,
            borderColor = JDSColor.Black,
            onClick = {}
        )
        JDSOutlinedButton(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = "text",
            enabled = false,
            textColor = JDSColor.ERROR,
            backgroundColor = JDSColor.MAIN,
            borderColor = JDSColor.Black,
            onClick = {}
        )
    }
}