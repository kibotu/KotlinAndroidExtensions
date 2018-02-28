package net.kibotu.kotlin.extensions

import android.content.Context
import android.content.Intent
import android.provider.Settings

/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */
object IntentExtensions {

    fun showSettings(context: Context) {
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun showDevSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}
