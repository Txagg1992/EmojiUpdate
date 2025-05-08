package com.curiousapps.emojiapiupdate.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.curiousapps.emojiapiupdate.domain.EmojiItem

@Composable
fun EmojiDialog(
    emojiItem: EmojiItem,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            elevation = 6.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(
                    modifier = modifier.align(Alignment.CenterHorizontally),
                    text = emojiItem.emoji,
                    fontSize = 100.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = modifier.align(Alignment.Start),
                    text = "TAG: ${emojiItem.annotation}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = modifier.align(Alignment.Start),
                    text = "HexCode: ${emojiItem.hexcode}",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
                Spacer(modifier = Modifier.height(6.dp))

            }
        }
    }
}