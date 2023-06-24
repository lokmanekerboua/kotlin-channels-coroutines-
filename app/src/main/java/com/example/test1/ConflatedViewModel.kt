package com.example.test1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConflatedViewModel : ViewModel() {
    private var channel: ReceiveChannel<Menu> = Channel()

    init {
        viewModelScope.launch {
            channel = produce(capacity = CONFLATED) {
                send(Menu.PIZZA)
                Log.d("MainViewModel", "first command sent")
                send(Menu.HOTDOG)
                Log.d("MainViewModel", "second command sent")
                send(Menu.DESSERT)
                Log.d("MainViewModel", "third command sent")
                send(Menu.FRIES)
                Log.d("MainViewModel", "fourth command sent")
            }
        }

        viewModelScope.launch {
            channel.consumeEach {
                Log.d("MainViewModel", "command received: ${it.name}")
            }
        }
    }
}