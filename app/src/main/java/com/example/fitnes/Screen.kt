package com.example.fitnes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnes.model.DailyTip
import com.example.fitnes.model.DailyTipsDataSource.dailyTips
import androidx.compose.foundation.lazy.items


@Composable
fun DailyTipCard(dailyTip: DailyTip, modifier: Modifier = Modifier){
    Card(modifier = modifier
        .clip(MaterialTheme.shapes.medium)
        .padding(8.dp, 16.dp)
    ){
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = dailyTip.day),
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(0.dp,8.dp)
            )
            Image(
                painter = painterResource(id = dailyTip.image),
                contentDescription = "tip1",
                modifier = modifier
                    .clip(MaterialTheme.shapes.medium),
            )
            Text(
                text = stringResource(id = dailyTip.tip),
                style = MaterialTheme.typography.labelLarge,
                modifier = modifier.padding(0.dp,8.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessMotivationTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row() {
                Text(text = stringResource(id = R.string.app_name),
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
fun FitnessMotivatioTipsApp(){
    Scaffold(
        topBar = { FitnessMotivationTopBar() }
    ) {
            it->
        LazyColumn(contentPadding = it){
            items(dailyTips){
                    dailyTip -> DailyTipCard(dailyTip = dailyTip)
            }
        }
    }

}



@Composable
@Preview
fun Preview(){
    FitnessMotivatioTipsApp()
}