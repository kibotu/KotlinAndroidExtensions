package net.kibotu.kotlin.extensions

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.KITKAT
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import net.kibotu.ContextHelper.getActivity
import net.kibotu.ContextHelper.getContext
import net.kibotu.ContextHelper.getFragmentActivity

/**
 * Created by Jan Rabe on 24/09/15.
 */
object ActivityExtensions {

    fun enableImmersiveMode() {
        if (SDK_INT < KITKAT)
            return

        val window = getActivity()!!.window
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility != 0)
                return@setOnSystemUiVisibilityChangeListener

            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    /**
     * This snippet hides the system bars.
     */
    fun hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        getActivity()!!.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar

                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar

                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            getActivity()!!.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    /**
     * This snippet shows the system bars. It does this by removing all the flags
     * except for the ones that make the content appear under the system bars.
     */
    fun showSystemUI() {
        getActivity()!!.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    val supportActionBar: ActionBar?
        get() = if (getFragmentActivity() != null)
            (getFragmentActivity() as AppCompatActivity).supportActionBar
        else
            null

    fun isPackageInstalled(packageName: String): Boolean {
        return try {
            getContext()!!.packageManager.getApplicationInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun prependMarketUrl(packageName: String): String {
        return "market://details?id=" + packageName
    }

    fun <T : Service> isServiceRunning(serviceClass: Class<T>): Boolean {
        val manager = getContext()!!.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        return manager.getRunningServices(Integer.MAX_VALUE).any { serviceClass.name == it.service.className }
    }

    val isInForeground: Boolean
        get() {
            val activity = getActivity()
            return activity != null && !activity.isFinishing && activity.window != null
        }
}
