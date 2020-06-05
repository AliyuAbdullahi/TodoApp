package com.jonathan.todos.dagger

import com.jonathan.todos.presentation.MainActivity
import dagger.Component

@Component(modules = [TodoServiceModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}
