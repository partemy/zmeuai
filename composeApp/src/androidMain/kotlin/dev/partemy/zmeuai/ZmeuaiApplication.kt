package dev.partemy.zmeuai

import android.app.Application
import dev.partemy.zmeuai.di.zmeuaiAppDI
import org.koin.android.ext.koin.androidContext

class ZmeuaiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        zmeuaiAppDI{
            androidContext(this@ZmeuaiApplication)
        }
    }
}