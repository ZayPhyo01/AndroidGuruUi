package com.guru.wecomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guru.otp_text_field.otp.OtpTextField
import com.guru.wecomposeui.ui.theme.WeComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeUiTheme {
                // A surface container using the 'background' color from the theme
                var numOtp by remember {
                    mutableStateOf("")
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.padding(24.dp)) {
                        OtpTextField(
                            num = numOtp,
                            modifier = Modifier.fillMaxWidth(),
                            isError = numOtp.length == 6
                        ) {
                            numOtp = it
                        }
                    }

                }
            }
        }
    }
}
