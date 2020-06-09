package com.jonathan.todos.domain.services

import com.jonathan.todos.domain.models.Todo
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 *
 */
interface TodoService {

    @GET(".")
    fun getTodos(): Observable<List<Todo>>
}

/**
 * Thread, (Hard to manage multiple threads, cleanup problems and possible memory leak)
 * AsyncTask, X (Boiler plate code, possible memory leak)
 * RxJava L (Boiler plate code)
 * Coroutines *** LL (All good)
 */
