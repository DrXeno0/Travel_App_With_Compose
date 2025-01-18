package com.nocturnal.travelappwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.nocturnal.travelappwithcompose.ui.components.Appbar
import com.nocturnal.travelappwithcompose.ui.components.BottomBar
import com.nocturnal.travelappwithcompose.ui.screens.HomeScreen
import com.nocturnal.travelappwithcompose.ui.theme.TravelAppWithComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val LightGray = Color(0xFFF8F8F8)
            val statusBarHeight = with(LocalDensity.current) {
                androidx.compose.foundation.layout.WindowInsets.statusBars.getTop(this).toDp()
            }

            TravelAppWithComposeTheme {
                Scaffold(
                    modifier = Modifier.padding(top = statusBarHeight + 4.dp),
                    topBar = { Appbar() },
                    bottomBar = {Box(modifier = Modifier.background(Color.White)) { BottomBar() }}
                ) { contentPadding ->
                    Box(
                        modifier = Modifier
                            .background(color = LightGray)
                            .padding(contentPadding)
                            .padding(16.dp)
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
