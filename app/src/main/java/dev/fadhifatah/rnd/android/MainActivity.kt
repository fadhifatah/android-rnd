package dev.fadhifatah.rnd.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fadhifatah.rnd.android.ui.theme.AndroidRndTheme

/**
 * Created by fadhifatah on 2023/10/03
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Compose block function
        setContent {
            AndroidRndTheme {
                Scaffold {
                    Content(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        context = LocalContext.current,
                        data = listOf(
                            "dev.fadhifatah.rnd.android.codelab.basics.BasicsActivity",
                            "dev.fadhifatah.rnd.android.codelab.basic_layouts.BasicLayoutsActivity",
                            "dev.fadhifatah.rnd.android.codelab.basic_state.BasicStateActivity",
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    data: List<String> = emptyList()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = data) { className ->
            val clazz = Class.forName(className)

            ElevatedButton(onClick = {
                with(context) {
                    startActivity(Intent(context, clazz))
                }
            }) {
                Text(text = clazz.simpleName)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content(
        modifier = Modifier.padding(16.dp),
        data = listOf(
            "dev.fadhifatah.rnd.android.codelab.basics.BasicsActivity",
            "dev.fadhifatah.rnd.android.codelab.basic_layouts.BasicLayoutsActivity",
        )
    )
}