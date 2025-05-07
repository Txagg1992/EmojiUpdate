package com.curiousapps.emojiapiupdate.domain

import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.http.Path

@ActivityScoped
interface EmojiListRepository {

    suspend fun fetchAllEmojis(): Result<List<EmojiItem>>

    suspend fun fetchOneEmoji(hexcode: String): Result<EmojiItem>
}