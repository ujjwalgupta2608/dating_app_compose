package com.app.dating.ui.screen

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.hilt.navigation.compose.hiltViewModel
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
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
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
        // Language Selector
        Box(
            modifier = Modifier
                .clickable { navController.navigate(Routes.SelectLanguage.route) }
                .align(Alignment.End)
                .padding(5.dp, 30.dp, 13.dp, 0.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.language_icon),
                contentDescription = "Language Icon",
                modifier = Modifier.size(26.dp)
            )
        }

        // Login Title
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

        // Subtitle
        Text(
            text = "Hi, welcome back! You’ve been missed",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(13.dp, 17.dp, 13.dp, 0.dp),
            fontSize = 15.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = GreyBoulder
        )

        // Email Input
        Text("Email or User ID", Modifier.padding(23.dp, 46.dp, 0.dp, 0.dp), fontSize = 13.sp, fontFamily = Inter)
        CustomEmailTextFieldLogin(viewModel, username)

        // Password Input
        Text("Password", Modifier.padding(23.dp, 6.dp, 0.dp, 0.dp), fontSize = 13.sp, fontFamily = Inter)
        CustomPasswordTextFieldLogin(viewModel, password)

        // Forgot Password
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .padding(23.dp, 6.dp, 23.dp, 0.dp)
                .align(Alignment.End)
                .clickable { /* Navigate to Forgot Password */ },
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = Theme,
            textDecoration = TextDecoration.Underline
        )

        // Login Button
        Box(
            modifier = Modifier
                .padding(24.dp, 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(Theme)
                .clickable { viewModel.login() }
                .padding(13.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.Black, strokeWidth = 2.dp, modifier = Modifier.size(20.dp))
            } else {
                Text("Login", color = WhiteWhisper, fontSize = 15.sp, fontFamily = Inter)
            }
        }
    }

    // Show Toast for errors
    LaunchedEffect(errorMessage) {
        if (errorMessage.isNotEmpty()) {
            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
/*@Composable
fun CustomPasswordTextFieldLogin(viewModel: LoginViewModel, password: String) {
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = WhiteWhisper, shape = RoundedCornerShape(8.dp))
            .padding(15.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                value = password,
                onValueChange = { viewModel.setPassword(it) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 13.sp),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    if (password.isEmpty()) {
                        Text(text = "Enter password", color = Color.Gray, fontSize = 13.sp)
                    }
                    innerTextField()
                }
            )
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(if (passwordVisible) R.drawable.open_eye else R.drawable.close_eye),
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    tint = Color.Gray
                )
            }

        }
    }
}*/

@Composable
fun CustomPasswordTextFieldLogin(viewModel: LoginViewModel, password: String) {
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
                onValueChange = { viewModel.setPassword(it) },
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


@Composable
fun CustomEmailTextFieldLogin(viewModel: LoginViewModel, username: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = WhiteWhisper, shape = RoundedCornerShape(8.dp))
            .padding(15.dp)
    ) {
        BasicTextField(
            value = username,
            onValueChange = { viewModel.setUsername(it) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(color = BlackMineShaft, fontSize = 13.sp),
            singleLine = true,
            decorationBox = { innerTextField ->
                if (username.isEmpty()) {
                    Text(text = "Enter email", color = GreyBoulder, fontSize = 13.sp)
                }
                innerTextField()
            }
        )
    }
}



