package com.guru.wecomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
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

                var isEnable by remember {
                    mutableStateOf(false)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(
                            text = "Login Me!", style = MaterialTheme.typography.h5.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Box(modifier = Modifier.padding(top = 24.dp)) {
                            OtpTextField(
                                modifier = Modifier.fillMaxWidth(),
                                isError = false
                            ) { text, isComplete ->
                                isEnable = isComplete

                            }
                        }
                        Spacer(modifier = Modifier.weight(1f, fill = true))
                        Button(
                            enabled = isEnable,
                            onClick = { }, modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .clip(RoundedCornerShape(20.dp))
                        ) {
                            Text(text = "Login")
                        }
                    }


                }
            }
        }
    }
}
