package com.curiousapps.emojiapiupdate.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.emojiapiupdate.domain.EmojiItem


@Composable
fun EmojiRow (
    emojiItem: EmojiItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(16.dp)
        ){
            Text(
                modifier = modifier.align(Alignment.CenterHorizontally),
                text = emojiItem.emoji,
                fontSize = 60.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "TAG: ${emojiItem.annotation}" ,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "HexCode: ${emojiItem.hexcode}" ,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(6.dp))
            Divider(
                thickness = 4.dp,
                color = Color.Blue
            )
        }
    }
}