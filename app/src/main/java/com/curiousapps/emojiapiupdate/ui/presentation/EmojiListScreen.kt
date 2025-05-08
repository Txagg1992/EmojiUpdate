package com.curiousapps.emojiapiupdate.ui.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.emojiapiupdate.ui.presentation.component.EmojiDialog
import com.curiousapps.emojiapiupdate.ui.presentation.component.EmojiRow
import com.curiousapps.emojiapiupdate.ui.presentation.component.GradientBackground

@Composable
fun EmojiListScreen(
  emojiListViewModel: EmojiListViewModel = hiltViewModel(),
  onSelectEmoji: (hexCode: String) -> Unit
){
    val context = LocalContext.current
    val state by emojiListViewModel.state.collectAsState(EmojiListViewModel.EmojiListState())
    val emojiList = state.emojiList
    val isLoading = state.isLoading
    val selectedEmoji = state.selectedEmoji

    GradientBackground()
    if (isLoading){
       Column(
           modifier = Modifier.fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           CircularProgressIndicator(
               modifier = Modifier.size(80.dp),
               trackColor = Color.Red,
               strokeWidth = 6.dp,
               strokeCap = StrokeCap.Round
           )
       }
    }else{
     Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(16.dp).padding(top = 32.dp, bottom = 24.dp)
     ){
         LazyColumn(
             modifier = Modifier.fillMaxSize()
         ) {
             val count = emojiList.size
             items(count = count){ index ->
                 val emoji = emojiList[index].emoji
                 val hexCode = emojiList[index].hexcode
                 EmojiRow(
                     modifier = Modifier.clickable {
                         onSelectEmoji(hexCode)
                         Toast.makeText(context, "GOT - $emoji",
                             Toast.LENGTH_SHORT).show()
                     },
                     emojiItem = emojiList[index]
                 )

                 if (selectedEmoji != null){
                     EmojiDialog(
                         emojiItem = selectedEmoji,
                         onDismiss = {emojiListViewModel.onDismissDialog()}
                     )
                 }
             }
         }
     }
    }
}