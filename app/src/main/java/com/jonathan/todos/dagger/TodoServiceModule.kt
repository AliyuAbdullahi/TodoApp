package com.jonathan.todos.dagger

import com.jonathan.todos.domain.services.TodoService
import com.jonathan.todos.presentation.TodoInteractor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class TodoServiceModule {

    @Provides
    fun provideTodoService(retrofit: Retrofit): TodoService = retrofit.create(TodoService::class.java)

    @Provides
    fun provideTodoInteractor(todoService: TodoService): TodoInteractor = TodoInteractor(todoService)
}
