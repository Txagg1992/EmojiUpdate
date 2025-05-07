package com.curiousapps.emojiapiupdate.util

import kotlinx.coroutines.Dispatchers

const val BASE_URL = "https://www.emoji.family/api/"
const val URL_EXT = "emojis"
const val URL_ONE = "emojis/{hexcode}"

val IO_DISPATCHER = Dispatchers.IO