package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Created by fadhifatah on 2023/10/03
 */
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTaskList(
            list = viewModel.tasks,
            onCloseTask = { viewModel.remove(it) },
            onCheckedTask = { task, value -> viewModel.changeTaskChecked(task, value) })
    }
}