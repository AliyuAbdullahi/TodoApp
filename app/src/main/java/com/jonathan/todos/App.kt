package com.jonathan.todos

import android.app.Application
import com.jonathan.todos.dagger.AppComponent
import com.jonathan.todos.dagger.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}
