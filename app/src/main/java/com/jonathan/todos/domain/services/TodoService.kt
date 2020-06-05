package com.jonathan.todos.domain.services

import com.jonathan.todos.domain.models.Todo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface TodoService {

    @GET(".")
    fun getTodos(): Observable<List<Todo>>
}
