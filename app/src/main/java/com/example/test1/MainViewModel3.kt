package com.example.test1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

class MainViewModel3 : ViewModel() {
    private var channel: ReceiveChannel<Menu> = Channel()

    init {
        viewModelScope.launch {
            channel = produce {
                send(Menu.PIZZA)
                send(Menu.HOTDOG)
                send(Menu.DESSERT)
            }
        }

        viewModelScope.launch {
            Log.d("MainViewModel", "${channel.isClosedForReceive}")
            channel.consumeEach {
                Log.d("MainViewModel", "command received: ${it.name}")
            }
            Log.d("MainViewModel", "${channel.isClosedForReceive}")
        }
    }
}