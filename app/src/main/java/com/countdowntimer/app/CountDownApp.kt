package com.countdowntimer.app

import android.app.Application
import com.countdowntimer.viewmodel.CountDownViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

/** The app level file of the project which creates dependencies using Koin **/
class CountDownApp : Application() {

    /** This function is called to initialize the process of creating dependencies **/
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CountDownApp)
            modules(viewModelModule)
        }

    }

    /** This variable stores the viewModel module dependency **/
    private val viewModelModule = module {
        viewModel { CountDownViewModel() }
    }

}