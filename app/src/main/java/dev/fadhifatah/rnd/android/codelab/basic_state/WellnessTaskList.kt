package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by fadhifatah on 2023/10/03
 */
@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { it.id }
        ) {
            WellnessTaskItem(
                taskName = it.label,
                onClose = { onCloseTask(it) },
                onCheckedChange = { newValue -> onCheckedTask(it, newValue) },
                checked = it.checked
            )
        }
    }
}