package com.app.dating.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.dating.R
import com.app.dating.navigation.AppNavigation
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.White
import com.app.dating.ui.theme.WhiteWhisper

//class SignupActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            SignUpScreen()
//
//        }
//    }
//}

@Preview
@Composable
fun SignUpScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(rememberScrollState()),
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
                .padding(52.dp, 17.dp, 52.dp, 0.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
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
        CustomNameTextField()
        Text(
            text = "Email",
            modifier = Modifier.padding(23.dp, 24.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomEmailTextField()
        Text(
            text = "Password",
            modifier = Modifier.padding(23.dp, 24.dp, 0.dp, 0.dp),
            fontSize = 13.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            color = BlackMineShaft
        )
        CustomPasswordTextField()
        Row(modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 18.dp),
            verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(R.drawable.unchecked_box),
                contentDescription = "agree checkbox")
            TermsAndConditionsText(
                onTermsClick = {
                    println("Terms & Conditions Clicked!")
                    // You can navigate to a Terms & Conditions screen or show a dialog
                }
            )
        }

        Box(
            modifier = Modifier
                .padding(24.dp, 28.dp, 24.dp, 0.dp)
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

        Row(modifier = Modifier.padding(24.dp, 31.dp, 24.dp, 0.dp)) {
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
                modifier = Modifier.padding(start = 10.dp)
//                    .clickable {
//                        navController.navigate(Routes.Login.route) {
//                        popUpTo(Routes.Login.route) { inclusive = true } // Clear all fragments in the back stack
//                    }
//                }
                ,
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
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
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
fun CustomNameTextField() {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
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

@Composable
fun CustomEmailTextField() {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
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
                            text = "Enter email", color = GreyBoulder, fontSize = 13.sp
                        )
                    }
                    innerTextField()
                })
        }
    }
}
@Composable
fun TermsAndConditionsText(
    onTermsClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        val fullText = stringResource(id = R.string.agree_with_terms)
        val termsStart = fullText.indexOf("Terms & Conditions") // Finds the phrase dynamically
        val termsEnd = termsStart + "Terms & Conditions".length

        append(fullText)

        // Apply color and underline to "Terms & Conditions"
        addStyle(
            style = SpanStyle(
                color = Color(0xFF6D53F4), // Custom color
                textDecoration = TextDecoration.Underline
            ),
            start = termsStart,
            end = termsEnd
        )

        // Make "Terms & Conditions" clickable
        addStringAnnotation(
            tag = "TERMS",
            annotation = "terms_clicked",
            start = termsStart,
            end = termsEnd
        )
    }

    ClickableText(
        text = annotatedText,
        style = TextStyle(
            fontFamily = Inter,
            fontSize = 12.sp,
            color = Color(0xFF242424) // Default text color
        ),
        modifier = Modifier.padding(start = 8.dp),
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                .firstOrNull()?.let { onTermsClick() }
        }
    )
}



