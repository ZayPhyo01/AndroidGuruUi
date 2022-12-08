package com.guru.otp_text_field.otp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

val OTP_SIZE = 6

@Composable
fun OtpTextField(
    initText: String = "",
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    onComplete: (String, Boolean) -> Unit
) {

    var numOtp by remember {
        mutableStateOf(initText)
    }

    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = numOtp,
        onValueChange = {
            if (it.length <= OTP_SIZE && it.isDigitsOnly()) {
                numOtp = it
                onComplete(it, it.length == OTP_SIZE)
            }

        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            repeat(OTP_SIZE) {
                OtpText(
                    direction = com.guru.otp_text_field.animation.Direction.TOP,
                    isError = isError,
                    modifier = Modifier.weight(1f),
                    text = if (it < numOtp.length) numOtp[it].toString()
                    else ""
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OtpSlotPreview() {
    OtpTextField(isError = false) { a, b -> }
}