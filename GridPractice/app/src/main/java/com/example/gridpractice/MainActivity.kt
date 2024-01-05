package com.example.gridpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridpractice.ui.theme.GridPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(68.dp)
            .fillMaxHeight()
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.picture),
                contentDescription = "",
                modifier = modifier
                    .aspectRatio(matchHeightConstraintsFirst = true, ratio = 1f)
            )
            Column(
                modifier = modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                    )

            ) {
                Text(
                    text = stringResource(id = topic.category),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier
                        .padding(bottom = 8.dp)
                    )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = ""
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 150.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(topics) {topic ->
                TopicCard(topic = topic)
            }
        },
        modifier = modifier
            .fillMaxSize()
            .padding(all = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TopicGrid(topics = DataSource.topics)
}
