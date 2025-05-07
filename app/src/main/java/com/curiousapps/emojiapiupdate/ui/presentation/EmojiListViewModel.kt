package com.curiousapps.emojiapiupdate.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousapps.emojiapiupdate.domain.EmojiItem
import com.curiousapps.emojiapiupdate.domain.EmojiListRepository
import com.curiousapps.emojiapiupdate.util.IO_DISPATCHER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EmojiListViewModel @Inject constructor(
    private val emojiListRepository: EmojiListRepository
) :ViewModel(){
    private val _state = MutableStateFlow(EmojiListState())
    val state = _state
        .onStart { fetchAllEmojis() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(4000L),
            EmojiListState()
        )

    private fun fetchAllEmojis(){
        viewModelScope.launch(IO_DISPATCHER) {
            val result = emojiListRepository.fetchAllEmojis()
            when{
                result.isSuccess -> {
                    _state.update { it.copy(
                        emojiList = result.getOrNull()!!,
                        isLoading = false
                    ) }
                }
                result.isFailure -> {
                    _state.update { it.copy(
                        emojiList = emptyList(),
                        isLoading = false
                    ) }
                }
            }
        }
    }

    data class EmojiListState(
        val emojiList: List<EmojiItem> = emptyList(),
        val isLoading: Boolean = true,
        val selectedEmoji: EmojiItem? = null
    )
}