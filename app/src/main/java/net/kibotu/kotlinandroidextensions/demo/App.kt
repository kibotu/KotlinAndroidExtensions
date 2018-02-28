package net.kibotu.kotlinandroidextensions.demo

import android.support.multidex.MultiDexApplication
import net.kibotu.logger.Logger

/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        Logger.addLogger(LogcatLogger(), if (BuildConfig.DEBUG)
            Logger.Level.VERBOSE
        else
            Logger.Level.SILENT)
    }

    override fun onTerminate() {
        super.onTerminate()

        Logger.onTerminate()
    }
}