package com.app.dating.ui.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
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


@Composable
fun SignUpScreen(navController: NavHostController) {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(White)
    ) {
        Box(
            modifier = Modifier
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
            text = "Create Account",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(13.dp, 22.dp, 13.dp, 0.dp),
            fontSize = 30.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = BlackMineShaft
        )
        Text(
            text = "Fill your information below or register with your social account.",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(13.dp, 17.dp, 13.dp, 0.dp),
            fontSize = 15.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            color = GreyBoulder
        )
        Text(
            text = "Name",
            modifier = Modifier.padding(23.dp, 46.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomEmailTextField()
        Text(
            text = "Password",
            modifier = Modifier.padding(23.dp, 6.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomPasswordTextField()

        Box(
            modifier = Modifier
                .padding(24.dp, 24.dp, 24.dp, 0.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp)) // Apply rounded corners
                .background(Theme) // Background color
                .padding(horizontal = 13.dp, vertical = 13.dp) // Padding inside the box
                .clickable {

                }
        ) {
            Text(
                text = "Sign Up",
                color = WhiteWhisper,
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
                text = "Or sign up with",
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
                text = "Already have an account?",
                color = GreyBoulder,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Login",
                color = Theme,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 10.dp).clickable {
                        navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Login.route) { inclusive = true } // Clear all fragments in the back stack
                    }
                },
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Composable
fun CustomPasswordTextField() {
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

@Composable
fun CustomEmailTextField() {
    var email by remember { mutableStateOf("") }

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
            BasicTextField(value = email,
                onValueChange = { email = it },
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = BlackMineShaft, fontSize = 13.sp
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (email.isEmpty()) {
                        Text(
                            text = "Enter name", color = GreyBoulder, fontSize = 13.sp
                        )
                    }
                    innerTextField()
                })
        }
    }
}
