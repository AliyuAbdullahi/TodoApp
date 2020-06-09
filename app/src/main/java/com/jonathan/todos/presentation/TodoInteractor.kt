package com.jonathan.todos.presentation

import com.jonathan.todos.domain.models.TodoResponse
import com.jonathan.todos.domain.services.TodoService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

class TodoInteractor @Inject constructor(private val todoService: TodoService) {

    private val todoSubject: BehaviorSubject<TodoResponse> = BehaviorSubject.create()
    public val todoObservable: @NonNull Observable<TodoResponse> =
        todoSubject.toFlowable(BackpressureStrategy.LATEST).toObservable()

    fun run() {
        todoSubject.onNext(TodoResponse.Pending)
        todoService.getTodos().subscribeOn(Schedulers.io())
            .subscribe(
                {
                    todoSubject.onNext(TodoResponse.Success(it))
                    todoSubject.onComplete()
                },
                {
                    todoSubject.onNext(TodoResponse.Error(it))
                    todoSubject.onComplete()
                }
            )
    }
}


/**
 * Publish Subject => Launch and forget
 * Relay Subject
 * Behavioral Subject
 */
