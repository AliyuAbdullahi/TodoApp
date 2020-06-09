package com.jonathan.todos.domain.models

sealed class TodoResponse {
    class Success(val data: Any): TodoResponse()
    class Error(val error: Throwable): TodoResponse()
    object Pending: TodoResponse()
}

