package com.example.test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test1.ui.theme.Test1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1Theme {
                //val viewModel = MainViewModel1()
                //val viewModel2 = MainViewModel2()
                //val viewModel3 = MainViewModel3()
                //val viewModel4 = BufferedViewModel()
                //val viewModel5 = ConflatedViewModel()
                //val viewModel6 = RendezVousViewModel()
                val viewModel7 = UnlimitedViewModel()
            }
        }
    }
}