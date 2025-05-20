package com.ibrohimapk3.easyenglish

import android.app.Application
import com.ibrohimapk3.easyenglish.DI.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}