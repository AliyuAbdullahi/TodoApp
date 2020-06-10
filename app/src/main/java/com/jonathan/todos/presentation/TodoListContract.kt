package com.jonathan.todos.presentation

import com.jonathan.todos.domain.models.Todo

interface TodoListContract {
    interface View {
        fun showTodos(list: List<Todo>)
        fun showLoading()
        fun hideLoading()
        fun showErrorMessage(error: Throwable)
    }

    interface Presenter{
        fun getTodo()
    }
}
