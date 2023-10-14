package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fadhifatah.rnd.android.ui.theme.AndroidRndTheme

/**
 * Created by fadhifatah on 2023/10/03
 */
@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    checked: Boolean,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(weight = 1f)
                .padding(start = 16.dp)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    onClose: () -> Unit,
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        modifier = modifier,
        onClose = onClose,
        onCheckedChange = { newValue -> checkedState = newValue },
        checked = checkedState,
        taskName = taskName
    )
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    AndroidRndTheme {
        WellnessTaskItem(onClose = {},
            onCheckedChange = {},
            checked = false,
            taskName = "This is a task name"
        )
    }
}