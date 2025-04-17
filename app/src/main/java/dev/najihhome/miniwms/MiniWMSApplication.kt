package dev.najihhome.miniwms

import android.app.Application
import dev.najihhome.miniwms.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MiniWMSApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MiniWMSApplication)
            modules(appModule)
        }
    }
}