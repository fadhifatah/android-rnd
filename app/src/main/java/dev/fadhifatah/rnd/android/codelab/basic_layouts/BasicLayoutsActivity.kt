@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package dev.fadhifatah.rnd.android.codelab.basic_layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fadhifatah.rnd.android.R
import dev.fadhifatah.rnd.android.ui.theme.AndroidRndTheme

class BasicLayoutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)
            App(windowSize)
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.placeholder_search))
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        ),
    )
}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    text: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = text,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    text: String,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.width(255.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = text,
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    data: List<String> = listOf(
        "Inversions",
        "Quick yoga",
        "Stretching",
        "Tabata",
        "HIIT",
        "Pre-natal yoga"
    ),
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(items = data) { item ->
            AlignYourBodyElement(text = item)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    data: List<String> = listOf(
        "Short mantras",
        "Nature meditations",
        "Stress and anxiety",
        "Self massage",
        "Overwhelmed",
        "Nightly wind down",
        "Insomniac"
    )
) {
    LazyHorizontalGrid(
        modifier = modifier.height(168.dp),
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(items = data) { _, item ->
            FavoriteCollectionCard(
                text = item,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium,
        )
        content()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(state = rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = stringResource(R.string.align_your_body)) {
            AlignYourBodyRow()
        }
        HomeSection(title = stringResource(R.string.favorite_collections)) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        // containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_profile))
            }
        )
    }
}

@Composable
fun RailNavigation(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier/* .padding(horizontal = 8.dp) */,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
            /* .padding(horizontal = 8.dp) */,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(R.string.bottom_navigation_home))
                }
            )
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(R.string.bottom_navigation_profile))
                }
            )
        }
    }
}

@Composable
fun AppPortrait() {
    AndroidRndTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation()
            }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun AppLandscape() {
    AndroidRndTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                RailNavigation()
                HomeScreen()
            }
        }
    }
}

@Composable
fun App(windowSize: WindowSizeClass) {
    when(windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            AppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            AppLandscape()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun SearchBarPreview() {
    AndroidRndTheme {
        SearchBar(modifier = Modifier.padding(8.dp))
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun AlignYourBodyElementPreview() {
    AndroidRndTheme {
        AlignYourBodyElement(
            text = "Inversions",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun FavoriteCollectionCardPreview() {
    AndroidRndTheme {
        FavoriteCollectionCard(
            text = "Nature meditations",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun AlignYourBodyRowPreview() {
    AndroidRndTheme {
        AlignYourBodyRow()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun FavoriteCollectionsGridPreview() {
    AndroidRndTheme {
        FavoriteCollectionsGrid()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
)
@Composable
fun HomeSectionPreview() {
    AndroidRndTheme {
        HomeSection(title = stringResource(R.string.align_your_body)) {
            AlignYourBodyRow()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFBFE,
    heightDp = 180
)
@Composable
fun HomeScreenPreview() {
    AndroidRndTheme {
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    AndroidRndTheme {
        BottomNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun RailNavigationPreview() {
    AndroidRndTheme {
        RailNavigation()
    }
}

@Preview(heightDp = 640, widthDp = 360)
@Composable
fun AppPortraitPreview() {
    AppPortrait()
}

@Preview(heightDp = 360, widthDp = 640)
@Composable
fun AppLandscapePreview() {
    AppLandscape()
}