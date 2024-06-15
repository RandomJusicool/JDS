package com.example.jds_component.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.jds_component.color.JDSColor
import com.example.jds_component.typography.JDSTypography

@Composable
fun JDSTextField(
    height: Dp,
    width: Dp,
    text: String,
    supportText: String = "",
    textFieldInfo: String,
    textState: String,
    onTextChange: (String) -> Unit,
    outlineColor: Color,
    textColor: Color = JDSColor.Black,
    backgroudColor: Color = JDSColor.WHITE,
    supportTextColor: Color = JDSColor.WHITE,
    isEnabled: Boolean = true,
    supportTextClick: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }
    val isFocused = remember { mutableStateOf(false) }
    val currentOnTextChange by rememberUpdatedState(newValue = onTextChange)

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        Text(
            text = text,
            color = textColor,
            style = JDSTypography.bodySmall
        )

        BasicTextField(
            value = textState,
            onValueChange = { newText -> currentOnTextChange(newText) },
            enabled = isEnabled,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = if (isFocused.value && outlineColor == JDSColor.GRAY200) JDSColor.MAIN else outlineColor,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .width(width)
                .height(height - 46.dp)
                .background(color = backgroudColor, shape = RoundedCornerShape(size = 8.dp))
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused.value = focusState.isFocused
                },
            decorationBox = { innerTextField ->
                Row {
                    if (textState.isEmpty()) {
                        Text(
                            text = textFieldInfo,
                            color = if (textState.isEmpty()) JDSColor.GRAY2 else JDSColor.Black,
                            style = JDSTypography.bodySmall,
                        )
                    }
                }
                innerTextField()
            }
        )

        Text(
            text = supportText,
            color = supportTextColor,
            style = JDSTypography.labelLarge,
            modifier = if (supportTextColor == JDSColor.MAIN) Modifier
                .align(Alignment.End)
                .clickable(enabled = supportTextClick) {} else Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JDSTextFieldPreview() {
    val textState = remember { mutableStateOf("") }

    Column {
        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.GRAY200,
            textState = textState.value,
            onTextChange = { textState.value = it }
        )

        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.MAIN,
            textState = textState.value,
            onTextChange = { textState.value = it }
        )

        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.GRAY300,
            backgroudColor = JDSColor.GRAY200,
            isEnabled = false,
            textState = textState.value,
            onTextChange = { textState.value = it }
        )

        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.SYSTEM,
            textColor = JDSColor.SYSTEM,
            supportText = "Error",
            supportTextColor = JDSColor.SYSTEM,
            textState = textState.value,
            onTextChange = { textState.value = it }
        )

        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.SYSTEM,
            textColor = JDSColor.SYSTEM,
            supportText = "영문, 숫자, 특수문자 중 2개 이상의 조합으로 8글자 이상",
            supportTextColor = JDSColor.MAIN,
            textState = textState.value,
            onTextChange = { textState.value = it }
        )

        JDSTextField(
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            width = 312.dp,
            height = 100.dp,
            outlineColor = JDSColor.SYSTEM,
            textColor = JDSColor.SYSTEM,
            supportText = "이메일 수정하기",
            supportTextColor = JDSColor.MAIN,
            textState = textState.value,
            onTextChange = { textState.value = it },
            supportTextClick = true
        )
    }
}
