import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import composables.CardContent
import kotlinx.coroutines.*

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        rememberCoroutineScope {
            CoroutineScope(Job() + Dispatchers.Default).launch {
                delay(300L)
                showContent = true
            }
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            AnimatedVisibility(showContent) {
                CardContent()
            }
        }
    }
}