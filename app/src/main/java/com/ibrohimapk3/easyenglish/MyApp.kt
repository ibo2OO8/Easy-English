package com.ibrohimapk3.easyenglish

import android.app.Application
import com.ibrohimapk3.easyenglish.DI.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
@HiltAndroidApp
class MyApp : Application()