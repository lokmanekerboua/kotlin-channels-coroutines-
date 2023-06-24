package com.example.test1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainViewModel1 : ViewModel() {
    private var channel = Channel<Menu>()

    init {

        //couroutine1 (producer)
        viewModelScope.launch {
            Log.d("MainViewModel", "first command sent")
            channel.send(Menu.PIZZA)
            Log.d("MainViewModel", "second command sent")
            channel.send(Menu.HOTDOG)
            channel.close()
        }

        //couroutine2 (consumer)
        viewModelScope.launch {
            Log.d("MainViewModel", "is the channel closed: " + channel.isClosedForReceive)
            Log.d("MainViewModel", "first command received: " + channel.receive())
            Log.d("MainViewModel", "second command received: " + channel.receive())
            Log.d("MainViewModel", "is the channel closed: " + channel.isClosedForReceive)
        }
    }
}