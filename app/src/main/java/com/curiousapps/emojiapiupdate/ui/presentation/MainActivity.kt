package com.curiousapps.emojiapiupdate.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.emojiapiupdate.ui.theme.EmojiApiUpdateTheme
import dagger.hilt.android.AndroidEntryPoint

//☠️
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmojiApiUpdateTheme {
                val viewmodel = hiltViewModel<EmojiListViewModel>()
                EmojiListScreen(
                    onSelectEmoji = { viewmodel.fetchOneEmoji(it) }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmojiApiUpdateTheme {
        Greeting("Android")
    }
}