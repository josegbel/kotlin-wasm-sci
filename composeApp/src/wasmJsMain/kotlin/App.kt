import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import icons.*
import kotlinx.coroutines.*
import utils.openLink

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
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Jose Garcia",
                        fontSize = 100.sp,
                        fontStyle = MaterialTheme.typography.h1.fontStyle,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        "Mobile Developer",
                        fontSize = 36.sp,
                        fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
                        letterSpacing = 0.5.sp
                    )
                    Row(Modifier.padding(top = 24.dp)) {
                        Image(
                            imageVector = SocialMediaPack.Github,
                            contentDescription = null,
                            modifier = Modifier.size(42.dp).clickable {
                                openLink("https://github.com/josegbel")
                            })
                        Spacer(modifier = Modifier.size(48.dp))
                        Image(
                            imageVector = SocialMediaPack.Linkedin,
                            contentDescription = null,
                            modifier = Modifier.size(42.dp).clickable {
                                openLink("https://www.linkedin.com/in/josegbel/")
                            }
                        )
                        Spacer(modifier = Modifier.size(48.dp))
                        Image(
                            imageVector = SocialMediaPack.Medium,
                            contentDescription = null,
                            modifier = Modifier.size(42.dp).clickable {
                                openLink("https://medium.com/@jose.gbel")
                            }
                        )
                        Spacer(modifier = Modifier.size(48.dp))
                        Image(
                            imageVector = SocialMediaPack.Gmail,
                            contentDescription = null,
                            modifier = Modifier.size(42.dp).clickable {
                                openLink("mailto:jose.gbel@gmail.com")
                            }
                        )
                        Spacer(modifier = Modifier.size(48.dp))
                        Image(
                            imageVector = SocialMediaPack.Instagram,
                            contentDescription = null,
                            modifier = Modifier.size(42.dp).clickable {
                                openLink("https://www.instagram.com/ypical.jose/")
                            }
                        )
                    }
                }
            }
        }
    }
}