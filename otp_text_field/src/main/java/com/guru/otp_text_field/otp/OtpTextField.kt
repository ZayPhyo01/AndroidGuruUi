package com.guru.otp_text_field.otp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val OTP_SIZE = 6

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    num: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {


    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = num,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            repeat(OTP_SIZE) {
                OtpText(
                    direction = com.guru.otp_text_field.animation.Direction.TOP,
                    isError = isError,
                    modifier = Modifier.weight(1f),
                    text = if (it < num.length) num[it].toString()
                    else ""
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OtpSlotPreview() {
    OtpTextField(num = "112763", isError = false) {}
}