package com.guru.otp_text_field.otp

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpText(
    modifier: Modifier = Modifier,
    text: String,
    unFocusBorderColor: Color = Color.Gray,
    focusBorderColor: Color = Color.Black,
    isError: Boolean = false
) {
    val borderColor = if (isError) Color.Red
    else if (text.isNotEmpty()) focusBorderColor else unFocusBorderColor

    val animateColor = animateColorAsState(targetValue = borderColor)
    Box(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color.White
            )
            .height(50.dp)
            .border(
                width = 1.2.dp,
                color = animateColor.value,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview()
@Composable
fun OtpTextPreview() {
    OtpText(text = "2")
}



