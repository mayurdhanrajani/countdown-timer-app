package com.countdowntimer.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.countdowntimer.view.CountDownScreen

/** This activity is used to show the screen component views **/
class CountDownActivity : ComponentActivity() {

    /** This function is called to initialize the process of building the app **/
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            CountDownApp()
        }
    }
}

/** This composable function will start building the app **/
@Composable
fun CountDownApp() {
    Column {
        Surface {
            CountDownScreen()
        }
    }
}