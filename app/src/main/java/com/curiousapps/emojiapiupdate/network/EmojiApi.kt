package com.curiousapps.emojiapiupdate.network

import com.curiousapps.emojiapiupdate.domain.EmojiItem
import com.curiousapps.emojiapiupdate.util.URL_EXT
import com.curiousapps.emojiapiupdate.util.URL_ONE
import retrofit2.http.GET
import retrofit2.http.Path

interface EmojiApi {

    @GET(URL_EXT)
    suspend fun fetchAllEmojis(): List<EmojiItem>

    @GET(URL_ONE)
    suspend fun fetchOneEmoji(
        @Path("hexcode") hexcode: String
    ): EmojiItem
}