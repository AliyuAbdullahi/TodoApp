package com.jonathan.todos.dagger

import com.jonathan.todos.presentation.MainActivity
import com.jonathan.todos.presentation.TodoListContract
import dagger.Binds
import dagger.Module

@Module
abstract class ActivityModule {

    @Binds
    abstract fun provideMainActivity(mainActivity: MainActivity): TodoListContract.View
}
