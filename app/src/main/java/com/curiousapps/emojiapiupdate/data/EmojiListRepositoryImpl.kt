package com.curiousapps.emojiapiupdate.data

import com.curiousapps.emojiapiupdate.domain.EmojiItem
import com.curiousapps.emojiapiupdate.domain.EmojiListRepository
import com.curiousapps.emojiapiupdate.network.EmojiApi
import okio.IOException
import javax.inject.Inject

class EmojiListRepositoryImpl @Inject constructor(
    private val emojiApi: EmojiApi
) : EmojiListRepository {
    override suspend fun fetchAllEmojis(): Result<List<EmojiItem>> {
        try {
            emojiApi.fetchAllEmojis().let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }

    override suspend fun fetchOneEmoji(hexcode: String): Result<EmojiItem> {
        try {
            emojiApi.fetchOneEmoji(hexcode).let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }
}