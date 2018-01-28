package net.kibotu.kotlinandroidextensions.demo;

import android.support.multidex.MultiDexApplication;

import net.kibotu.kotlinandroidextension.ContextHelper;

/**
 * Created by <a href="https://about.me/janrabe">Jan Rabe</a>.
 */
public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextHelper.with(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        ContextHelper.onTerminate();
    }
}