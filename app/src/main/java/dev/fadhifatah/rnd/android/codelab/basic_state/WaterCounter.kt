package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fadhifatah.rnd.android.ui.theme.AndroidRndTheme

/**
 * Created by fadhifatah on 2023/10/03
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        modifier = modifier,
        count = count,
        onIncrement = { count++ }
    )
}

@Composable
fun StatelessCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            /* var showTask: Boolean by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken your 15 minutes walk today?"
                )
            } */
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
        /* Row(modifier = Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(start = 8.dp),
            ) {
                Text(text = "Clear water count")
            }
        } */
    }
}

@Preview
@Composable
fun WaterCounterPreview() {
    AndroidRndTheme {
        StatefulCounter()
    }
}