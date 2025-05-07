package com.curiousapps.emojiapiupdate.domain


import com.google.gson.annotations.SerializedName

data class EmojiItem(
    @SerializedName("annotation")
    var `annotation`: String,
    @SerializedName("directional")
    var directional: Boolean,
    @SerializedName("emoji")
    var emoji: String,
    @SerializedName("emoticons")
    var emoticons: List<String>,
    @SerializedName("group")
    var group: String,
    @SerializedName("hexcode")
    var hexcode: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("shortcodes")
    var shortcodes: List<String>,
    @SerializedName("skintone")
    var skintone: Int,
    @SerializedName("skintoneBase")
    var skintoneBase: String,
    @SerializedName("skintoneCombination")
    var skintoneCombination: String,
    @SerializedName("subgroup")
    var subgroup: String,
    @SerializedName("tags")
    var tags: List<String>,
    @SerializedName("unicode")
    var unicode: Double,
    @SerializedName("variation")
    var variation: Boolean,
    @SerializedName("variationBase")
    var variationBase: Any
)