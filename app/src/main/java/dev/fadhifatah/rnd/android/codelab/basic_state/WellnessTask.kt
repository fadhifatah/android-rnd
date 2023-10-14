package dev.fadhifatah.rnd.android.codelab.basic_state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Created by fadhifatah on 2023/10/03
 */
data class WellnessTask(
    val id: Int,
    val label: String,
    var initialChecked: Boolean = false,
) {
    var checked by mutableStateOf(initialChecked)
}
