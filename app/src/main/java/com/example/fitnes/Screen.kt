package com.example.fitnes

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnes.model.DailyTip
import com.example.fitnes.model.DailyTipsDataSource.dailyTips

@Composable
fun DailyTipCard(dailyTip: DailyTip, modifier: Modifier = Modifier) {
    // Track the expanded state
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(8.dp, 16.dp)
            .animateContentSize() // Animate the card size when content changes
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            // Title
            Text(
                text = stringResource(id = dailyTip.day),
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(0.dp, 8.dp)
            )

            // Always visible image
            Image(
                painter = painterResource(id = dailyTip.image),
                contentDescription = "Tip image",
                modifier = modifier
                    .clip(MaterialTheme.shapes.medium)
                    .padding(0.dp, 8.dp)
            )

            // Button to toggle visibility
            Button(
                onClick = { expanded = !expanded },
                modifier = modifier.padding(vertical = 8.dp)
            ) {
                Text(if (expanded) "Less" else "More")
            }

            // Conditionally show the text below the button
            if (expanded) {
                Text(
                    text = stringResource(id = dailyTip.tip),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = modifier.padding(0.dp, 8.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessMotivationTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = modifier.padding(8.dp)
                )
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessMotivatioTipsApp() {
    Scaffold(
        topBar = { FitnessMotivationTopBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(dailyTips) { dailyTip ->
                DailyTipCard(dailyTip = dailyTip)
            }
        }
    }
}

@Composable
@Preview
fun Preview() {
    FitnessMotivatioTipsApp()
}
