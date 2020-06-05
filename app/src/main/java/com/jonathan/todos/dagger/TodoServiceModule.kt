package com.jonathan.todos.dagger

import com.jonathan.todos.domain.services.TodoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class TodoServiceModule {

    @Provides
    fun provideTodoService(retrofit: Retrofit): TodoService = retrofit.create(TodoService::class.java)
}
