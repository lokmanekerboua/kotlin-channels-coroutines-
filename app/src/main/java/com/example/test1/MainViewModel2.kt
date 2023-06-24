package com.example.test1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class MainViewModel2 : ViewModel() {
    val channel = Channel<Menu>()

    init {
        viewModelScope.launch {
            Log.d("MainViewModel", "first command sent")
            channel.send(Menu.FRIES)
            Log.d("MainViewModel", "second command sent")
            channel.send(Menu.HOTDOG)
            Log.d("MainViewModel", "third command sent")
            channel.send(Menu.DESSERT )
            channel.close()
        }

        viewModelScope.launch {
            channel.consumeEach {
                Log.d("MainViewModel", "command received: ${it.name}")
            }
        }
    }
}