package com.app.dating.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.dating.R
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.White
import com.app.dating.ui.theme.WhiteWhisper

/*class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginOTPScreen()

        }
    }*/

    @Preview
    @Composable
    fun LoginOTPScreen() {
        Column(
            Modifier
                .fillMaxSize()
                .background(White)
                .verticalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(R.drawable.back_button),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(start = 24.dp, top = 20.dp)
                    .clickable {

                    })
            Text(
                fontSize = 25.sp,
                text = "Tell us your Phone Number?",
                color = BlackMineShaft,
                modifier = Modifier.padding(start = 78.dp, end = 78.dp),
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                fontSize = 13.sp,
                text = "Please enter the mobile number associated with this account",
                color = GreyBoulder,
                modifier = Modifier.padding(start = 78.dp, end = 78.dp, top = 18.dp),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            var otp /*by remember { mutableStateOf("") }*/=""

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OtpInputField(otpValue = otp, onOtpChange = { otp = it })
            }
        }
    }
    @Composable
    fun OtpInputField(otpValue: String, onOtpChange: (String) -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp, top = 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in 0 until 4) {
                val char = otpValue.getOrNull(i)?.toString() ?: ""
                OtpBox(char = char, isFocused = otpValue.length == i) // Highlight the focused box
            }
        }

        BasicTextField(
            value = otpValue,
            onValueChange = {
                if (it.length <= 4 && it.all { char -> char.isDigit() }) {
                    onOtpChange(it)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
                .offset(y = (-32).dp), // Moves the input out of sight while keeping it functional
            decorationBox = {}
        )
    }

    @Composable
    fun OtpBox(char: String, isFocused: Boolean) {
        Box(
            modifier = Modifier
                .size(width = 58.dp, height = 32.dp)
                .background(
                    color = Color(0xFFF5F5F5), // Equivalent to android:itemBackground="@color/white_whisper"
                    shape = RoundedCornerShape(8.dp)
                )
                .border(
                    width = if (isFocused) 1.dp else 0.dp,
                    color = if (isFocused) Color.Black else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = char,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }


//}