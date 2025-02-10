package com.app.dating.ui.screen.language

import com.app.dating.model.languages
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.dating.R
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.White
import com.app.dating.ui.theme.WhiteWhisper
import com.app.dating.ui.theme.Typography

@Composable
fun SelectLanguageScreen(navController: NavHostController, previousScreen: String, viewModel: LocaleViewModel = hiltViewModel()) {
    // List of languages
    var selectedLanguage by remember { mutableStateOf(languages[0].first) }
    Column(
        Modifier
            .fillMaxSize()
            .background(White)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 40.dp, 24.dp, 24.dp),
        ) {
            if (previousScreen!="splash"){
                Image(
                    painter = painterResource(R.drawable.back_button),
                    contentDescription = "Back Button",
                    modifier = Modifier.clickable {

                    }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(R.string.select_language),
                    style = Typography.displayLarge,
                )
            }
        }

        // Language List
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(languages) { (language, code) ->
                ItemList(language = language,
                    isSelected = selectedLanguage == language,
                    onLanguageSelected = { selectedLanguage = language })
            }
        }

        // Update Language Button
        Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp), colors = CardDefaults.cardColors(
            containerColor = White
        ), modifier = Modifier
            .fillMaxWidth()
            .clickable {
                viewModel.changeLanguage(languages.find { it.first == selectedLanguage }?.second ?: "en")
                navController.navigate(Routes.Welcome.route)
            }) {
            Box(
                modifier = Modifier
                    .padding(24.dp, 16.dp, 24.dp, 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp)) // Apply rounded corners
                    .background(Theme) // Background color
                    .padding(horizontal = 13.dp, vertical = 13.dp) // Padding inside the box
            ) {
                Text(
                    text = stringResource(R.string.update_language),
                    color = WhiteWhisper,
                    fontSize = 15.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(Alignment.Center) // Center the text in the Box
                )
            }
        }
    }
}

@Composable
fun ItemList(language: String, isSelected: Boolean, onLanguageSelected: (String) -> Unit) {
    Log.d("TAG", "SelectLanguageScreen: ")
    Box(modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 8.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
            .background(/*if (isSelected) Theme else */WhiteWhisper) // Highlight selected item
            .padding(20.dp, 14.dp, 20.dp, 14.dp)
            .clickable { onLanguageSelected(language) } // Handle item click
        ) {
            Text(
                text = language,
                color = if (isSelected) BlackMineShaft else GreyBoulder,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 26.dp, 0.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(
                    if (isSelected) R.drawable.selected_circle else R.drawable.unselected_circle
                ), contentDescription = "language selection"
            )
        }
    }
}
