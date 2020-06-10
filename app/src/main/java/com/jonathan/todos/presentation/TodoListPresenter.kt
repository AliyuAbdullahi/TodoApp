package com.jonathan.todos.presentation

import com.jonathan.todos.domain.models.Todo
import com.jonathan.todos.domain.models.TodoResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class TodoListPresenter @Inject constructor(
    private val interactor: TodoInteractor,
    private val view: TodoListContract.View
) : TodoListContract.Presenter {

    override fun getTodo() {
        interactor.todoObservable.observeOn(AndroidSchedulers.mainThread())
            .subscribe({ todoResponse ->
                when (todoResponse) {
                    is TodoResponse.Success -> {
                        view.hideLoading()
                        view.showTodos(todoResponse.data as List<Todo>)
                    }
                    is TodoResponse.Pending -> view.showLoading()
                    is TodoResponse.Error -> {
                        view.hideLoading()
                        view.showErrorMessage(todoResponse.error)
                    }
                }
            }, {
                view.showErrorMessage(it)
            })

        interactor.run()
    }

}
