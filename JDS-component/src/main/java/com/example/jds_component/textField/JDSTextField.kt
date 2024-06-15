package com.example.jds_component.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.jds_component.color.JDSColor
import com.example.jds_component.modifier.clickableSingle.clickableSingle
import com.example.jds_component.typography.JDSTypography

@Composable
fun JDSTextField(
    modifier: Modifier = Modifier,
    text: String,
    supportText: String = "",
    textFieldInfo: String,
    textState: String,
    outlineColor: Color,
    backgroudColor: Color = JDSColor.WHITE,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    supportTextClick: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (String) -> Unit,
    onClickSupportText: () -> Unit = {}
) {
    val focusRequester = remember { FocusRequester() }
    val isFocused = remember { mutableStateOf(false) }
    val currentOnTextChange by rememberUpdatedState(newValue = onTextChange)

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            color = if (isError) JDSColor.SYSTEM else JDSColor.Black,
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
                .height(54.dp)
                .fillMaxWidth()
                .background(
                    color = backgroudColor,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused.value = focusState.isFocused
                },
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
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
            color = if (isError) JDSColor.SYSTEM else JDSColor.MAIN,
            style = JDSTypography.labelLarge,
            modifier = if (!isError) Modifier
                .align(Alignment.End)
                .clickableSingle(
                    enabled = supportTextClick,
                    onClick = onClickSupportText
                ) else Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JDSTextFieldPreview() {
    val (textState, onTextChange) = remember { mutableStateOf("") }

    Column {
        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.GRAY200,
            textState = textState,
            onTextChange = onTextChange
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.MAIN,
            textState = textState,
            onTextChange = onTextChange
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.GRAY300,
            backgroudColor = JDSColor.GRAY200,
            isEnabled = false,
            textState = textState,
            onTextChange = onTextChange
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.SYSTEM,
            supportText = "Error",
            isError = true,
            textState = textState,
            onTextChange = onTextChange
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.GRAY200,
            textState = textState,
            onTextChange = onTextChange,
            visualTransformation = PasswordVisualTransformation()
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.SYSTEM,
            supportText = "영문, 숫자, 특수문자 중 2개 이상의 조합으로 8글자 이상",
            textState = textState,
            onTextChange = onTextChange
        )

        JDSTextField(
            modifier = Modifier
                .width(312.dp)
                .height(100.dp),
            text = "아이디",
            textFieldInfo = "아이디를 입력해주세요",
            outlineColor = JDSColor.SYSTEM,
            supportText = "이메일 수정하기",
            textState = textState,
            onTextChange = onTextChange,
            supportTextClick = true,
            onClickSupportText = {}
        )
    }
}