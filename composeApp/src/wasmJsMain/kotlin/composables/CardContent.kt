@file:OptIn(ExperimentalComposeUiApi::class)

package composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import icons.*
import kotlinx.coroutines.*
import utils.Colors
import utils.openLink
import utils.transparentClickable

@Composable
fun CardContent() {
    var showContent by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        delay(300L)
        showContent = true
    }

    BoxWithConstraints (modifier = Modifier.fillMaxSize()) {

        val screenHeight = maxHeight
        val topSpacerHeight = screenHeight * 0.35f
        val bottomSpacerHeight = screenHeight * 0.40f

        AnimatedVisibility(
            visible = showContent,
            enter = slideInVertically(
                initialOffsetY = { -it * 5 },
                animationSpec = tween(1000)
            ) + fadeIn(tween(1000)),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column {
                Spacer(modifier = Modifier.height(topSpacerHeight))
                Text(
                    "Jose Garcia",
                    fontSize = 100.sp,
                    // Style adjustments
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            AnimatedVisibility(
                visible = showContent,
                enter = fadeIn(animationSpec = tween(6500)),
            ) {
                Text(
                    "Mobile Developer",
                    fontSize = 36.sp,
                    fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
                    letterSpacing = 0.5.sp
                )
            }
        }

        AnimatedVisibility(
            visible = showContent,
            enter = slideInVertically(
                // Start from below the screen
                initialOffsetY = { it * 5 },
                animationSpec = tween(1000)
            ) + fadeIn(animationSpec = tween(1000)),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Column {
                Socials()
                Spacer(modifier = Modifier.height(bottomSpacerHeight))
            }
        }
    }
}

@Composable
fun Socials() {
    var isGithubHover by remember { mutableStateOf(false) }
    var isLinkedinHover by remember { mutableStateOf(false) }
    var isMediumHover by remember { mutableStateOf(false) }
    var isGmailHover by remember { mutableStateOf(false) }
    var isInstagramHover by remember { mutableStateOf(false) }

    val gitHubScale by animateFloatAsState(
        targetValue = if (isGithubHover) 1.2f else 1f,
        animationSpec = TweenSpec(durationMillis = 300)
    )
    val linkedinScale by animateFloatAsState(
        targetValue = if (isLinkedinHover) 1.2f else 1f,
        animationSpec = TweenSpec(durationMillis = 300)
    )
    val mediumScale by animateFloatAsState(
        targetValue = if (isMediumHover) 1.2f else 1f,
        animationSpec = TweenSpec(durationMillis = 300)
    )
    val gmailScale by animateFloatAsState(
        targetValue = if (isGmailHover) 1.2f else 1f,
        animationSpec = TweenSpec(durationMillis = 300)
    )
    val instagramScale by animateFloatAsState(
        targetValue = if (isInstagramHover) 1.2f else 1f,
        animationSpec = TweenSpec(durationMillis = 300)
    )

    val githubTint = if (isGithubHover) Colors.GitHub else MaterialTheme.colors.onBackground
    val linkedInTint = if (isLinkedinHover) Colors.LinkedIn else MaterialTheme.colors.onBackground
    val mediumTint = if (isMediumHover) Colors.Medium else MaterialTheme.colors.onBackground
    val gmailTint = if (isGmailHover) Colors.Gmail else MaterialTheme.colors.onBackground
    val instagramTint = if (isInstagramHover) Colors.Instagram else MaterialTheme.colors.onBackground

    Row {
        Icon(
            imageVector = SocialMediaPack.Github,
            contentDescription = null,
            tint = githubTint,
            modifier = Modifier
                .size(42.dp)
                .transparentClickable {
                    openLink("https://github.com/josegbel")
                }
                .scale(gitHubScale)
                .onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        isGithubHover = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = {
                        isGithubHover = false
                    }
                )
        )
        Spacer(modifier = Modifier.size(48.dp))
        Icon(
            imageVector = SocialMediaPack.Linkedin,
            contentDescription = null,
            tint = linkedInTint,
            modifier = Modifier
                .size(42.dp)
                .transparentClickable {
                    openLink("https://www.linkedin.com/in/josegbel/")
                }
                .scale(linkedinScale)
                .onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        isLinkedinHover = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = {
                        isLinkedinHover = false
                    }
                )
        )
        Spacer(modifier = Modifier.size(48.dp))
        Icon(
            imageVector = SocialMediaPack.Medium,
            contentDescription = null,
            tint = mediumTint,
            modifier = Modifier
                .size(42.dp)
                .transparentClickable {
                    openLink("https://medium.com/@jose.gbel")
                }
                .scale(mediumScale)
                .onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        isMediumHover = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = {
                        isMediumHover = false
                    }
                )
        )
        Spacer(modifier = Modifier.size(48.dp))
        Icon(
            imageVector = SocialMediaPack.Gmail,
            contentDescription = null,
            tint = gmailTint,
            modifier = Modifier
                .size(42.dp)
                .transparentClickable {
                    openLink("mailto:jose.gbel@gmail.com")
                }
                .scale(gmailScale)
                .onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        isGmailHover = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = {
                        isGmailHover = false
                    }
                )
        )
        Spacer(modifier = Modifier.size(48.dp))
        Icon(
            imageVector = SocialMediaPack.Instagram,
            contentDescription = null,
            tint = instagramTint,
            modifier = Modifier
                .size(42.dp)
                .transparentClickable {
                    openLink("https://www.instagram.com/ypical.jose/")
                }
                .scale(instagramScale)
                .onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        isInstagramHover = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = {
                        isInstagramHover = false
                    }
                )
        )
    }
}
