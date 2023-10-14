package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

/**
 * Created by fadhifatah on 2023/10/03
 */
private fun getWellnessTask() =
    List(size = 30) { index -> WellnessTask(id = index, label = "Task # $index") }

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTask().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == task.id }?.let { it.checked = checked }
    }
}