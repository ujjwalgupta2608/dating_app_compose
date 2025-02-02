package com.app.dating.ui.screen

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dating.R
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.White
import com.app.dating.ui.theme.WhiteWhisper
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.view_model.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginFlow(navController: NavHostController) {
    val context = LocalContext.current.getActivity()
    BackHandler {
        context?.finish()
    }
    LoginScreen(navController)
}

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = viewModel()) {
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()

    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(White)
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    navController.navigate(Routes.SelectLanguage.route)
                }
                .align(Alignment.End)
                .padding(5.dp, 30.dp, 13.dp, 0.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.language_icon),
                contentDescription = "Language Icon",
                modifier = Modifier.size(26.dp, 26.dp)
            )
        }
        Text(
            text = "Login",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(13.dp, 22.dp, 13.dp, 0.dp),
            fontSize = 30.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = BlackMineShaft
        )
        Text(
            text = "Hi Welcome back, you’ve been missed",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(13.dp, 17.dp, 13.dp, 0.dp),
            fontSize = 15.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = GreyBoulder
        )
        Text(
            text = "Email or User ID",
            modifier = Modifier.padding(23.dp, 46.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomEmailTextFieldLogin(viewModel)
        Text(
            text = "Password",
            modifier = Modifier.padding(23.dp, 6.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomPasswordTextFieldLogin()
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .padding(23.dp, 6.dp, 23.dp, 0.dp)
                .align(Alignment.End),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = Theme,
            textDecoration = TextDecoration.Underline
        )
        Box(
            modifier = Modifier
                .padding(24.dp, 24.dp, 24.dp, 0.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp)) // Apply rounded corners
                .background(Theme) // Background color
                .padding(horizontal = 13.dp, vertical = 13.dp)
                .clickable {

                },

            ) {
            Text(
                text = "Login",
                color = WhiteWhisper,
                fontSize = 15.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.Center) // Center the text in the Box
            )
        }
        Box(
            modifier = Modifier
                .padding(24.dp, 16.dp, 24.dp, 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp)) // Apply rounded corners
                .background(WhiteWhisper) // Background color
                .padding(horizontal = 13.dp, vertical = 13.dp) // Padding inside the box
        ) {
            Text(
                text = "Login with Mobile",
                color = GreyBoulder,
                fontSize = 15.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.Center) // Center the text in the Box
            )
        }
        Row(modifier = Modifier.padding(24.dp, 15.dp, 24.dp, 0.dp)) {
            HorizontalDivider(
                color = WhiteWhisper,
                thickness = 2.dp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "Or login with",
                modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 0.dp),
                color = GreyBoulder,
                fontSize = 13.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )
            HorizontalDivider(
                color = WhiteWhisper,
                thickness = 2.dp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
        }
        Row(
            modifier = Modifier
                .padding(24.dp, 36.dp, 24.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.google_login),
                contentDescription = "Facebook Login",
                modifier = Modifier.padding(end = 25.dp)
            )
            Image(
                painter = painterResource(R.drawable.facebook_login),
                contentDescription = "Google Login"
            )
        }

        Row(
            modifier = Modifier
                .padding(24.dp, 36.dp, 24.dp, 24.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Don't have an account?",
                color = GreyBoulder,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Sign Up",
                color = Theme,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 10.dp)
                    .clickable { navController.navigate(Routes.Signup.route) },
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Composable
fun CustomPasswordTextFieldLogin() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = WhiteWhisper, shape = RoundedCornerShape(8.dp)
            )
            .padding(start = 15.dp) // Inner padding for the content
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(value = password,
                onValueChange = { password = it },
                modifier = Modifier.weight(1f), // Adjust vertical padding
                textStyle = TextStyle(
                    color = Color.Black, fontSize = 13.sp
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (password.isEmpty()) {
                        Text(
                            text = "Enter password", color = Color.Gray, fontSize = 13.sp
                        )
                    }
                    innerTextField()
                })

            val icon =
                if (passwordVisible) painterResource(id = R.drawable.open_eye) else painterResource(
                    id = R.drawable.close_eye
                )
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = icon, contentDescription = description, tint = Color.Gray
                )
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CustomEmailTextFieldLogin(viewModel: LoginViewModel) {
//    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = WhiteWhisper, shape = RoundedCornerShape(8.dp)
            )
            .padding(start = 15.dp, top = 15.dp, bottom = 15.dp) // Inner padding for the content
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(value = viewModel.username.value,
                onValueChange = { viewModel.password.value  = it },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = BlackMineShaft, fontSize = 13.sp
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (viewModel.username.value.isEmpty()) {
                        Text(
                            text = "Enter email", color = GreyBoulder, fontSize = 13.sp
                        )
                    }
                    innerTextField()
                })
        }
    }
}


