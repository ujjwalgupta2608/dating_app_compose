package com.app.dating.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dating.R
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.White
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.WhiteWhisper

/*class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginWithMobileFlow()

        }
    }*/

    @Composable
     fun LoginWithMobileFlow(navController: NavHostController) {
        var phoneNumber by remember { mutableStateOf("") }
        var countryCode by remember { mutableStateOf("27") } // Default to South Africa


        Column(
            Modifier
                .fillMaxSize()
                .background(White)
                .verticalScroll(rememberScrollState())
        ) {
            Image(painter = painterResource(R.drawable.back_button),
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(start = 24.dp, top = 40.dp)
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
            Text(
                fontSize = 13.sp,
                text = "Phone Number",
                color = BlackMineShaft,
                modifier = Modifier.padding(start = 23.dp, top = 39.dp),
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 18.dp, top = 8.dp)
                    .background(
                        color = WhiteWhisper, // Adjust to match your background
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                    .padding(vertical = 9.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Country Code Picker Placeholder
                    CountryCodePicker(selectedCountryCode = countryCode, onCountryChange = { newCode ->
                        countryCode = newCode
                    })

                    Spacer(modifier = Modifier.width(12.dp)) // Space between picker and text field

                    // Input Field
                    BasicTextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        modifier = Modifier
                            .weight(1f),
                        decorationBox = { innerTextField ->
                            if (phoneNumber.isEmpty()) {
                                Text(
                                    text = "Enter Phone Number", color = GreyBoulder, fontSize = 13.sp
                                )
                            }
                            innerTextField()
                        },
                        textStyle = TextStyle(color = BlackMineShaft, fontSize = 13.sp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        /*colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        )*/
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top =47.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Theme)
                    .clickable {
                        navController.navigate(Routes.LoginOTP.route)
                    }
                    .padding(13.dp),
                contentAlignment = Alignment.Center
            ) {
                if (/*isLoading*/false) {
                    CircularProgressIndicator(color = Color.Black, strokeWidth = 2.dp, modifier = Modifier.size(20.dp))
                } else {
                    Text("Send OTP", color = WhiteWhisper, fontSize = 15.sp, fontFamily = Inter)
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 15.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(WhiteWhisper)
                    .clickable {
                        navController.navigate(Routes.Login.route){
                            popUpTo(Routes.Login.route){
                                inclusive = true
                            }
                        }
                    }
                    .padding(13.dp),
                contentAlignment = Alignment.Center
            ) {
                if (/*isLoading*/false) {
                    CircularProgressIndicator(color = Color.Black, strokeWidth = 2.dp, modifier = Modifier.size(20.dp))
                } else {
                    Text("Login with Email", color = GreyBoulder, fontSize = 15.sp, fontFamily = Inter)
                }
            }
        }
    }

    @Composable
    fun CountryCodePicker() {
        // Placeholder for Country Code Picker
        Text(
            text = "+27",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
@Composable
fun CountryCodePicker(selectedCountryCode: String, onCountryChange: (String) -> Unit) {
    AndroidView(
        factory = { context ->
            com.hbb20.CountryCodePicker(context).apply {
                setDefaultCountryUsingPhoneCode(selectedCountryCode.toIntOrNull() ?: 1)
                setOnCountryChangeListener {
                    onCountryChange(selectedCountryCode)
                }
                setTextSize(34)
                setDialogTextColor(R.color.black)
                showFlag(false) // Hide flag if not needed
            }
        },
        modifier = Modifier.padding(start = 10.dp)
    )
}

//}