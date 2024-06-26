package com.jusiCool.jds_component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.jusiCool.jds_component.color.JDSColor
import com.jusiCool.jds_component.modifier.clickableSingle.clickableSingle
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun JDSToggleButton(
    modifier: Modifier = Modifier,
    height: Dp,
    width: Dp,
    isSelected: Boolean,
    buttonColor: Color = JDSColor.WHITE,
    onClick: () -> Unit,
    setIsSelected: (Boolean) -> Unit,
) {
    val sizePx = with(LocalDensity.current) { (width - height).toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    val coroutineScope = rememberCoroutineScope()
    val swipeableState = rememberSwipeableState(0, confirmStateChange = { newState ->
        setIsSelected(newState == 1)
        true
    })
    val backgroundColor by remember {
        derivedStateOf {
            lerp(
                JDSColor.MAIN, JDSColor.GRAY200,
                swipeableState.offset.value / sizePx
            )
        }
    }


    Row(
        modifier = modifier
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .clickableSingle {
                onClick()
                setIsSelected(!isSelected)
                coroutineScope.launch {
                    swipeableState.animateTo(if (isSelected) 0 else 1)
                }
            }
            .height(height)
            .width(width)
            .clip(RoundedCornerShape(height))
            .background(backgroundColor)
            .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(height - 6.dp)
                .clip(RoundedCornerShape(50))
                .background(buttonColor)
        )
    }
}

@Preview
@Composable
fun JDSToggleButtonPreview() {
    val (isSelected, setIsSelected) = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        JDSToggleButton(
            height = 50.dp,
            width = 200.dp,
            isSelected = isSelected,
            onClick = { },
            setIsSelected = setIsSelected
        )
    }
}
