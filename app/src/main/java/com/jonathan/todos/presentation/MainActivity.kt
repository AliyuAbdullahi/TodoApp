package com.jonathan.todos.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.todos.App
import com.jonathan.todos.R
import com.jonathan.todos.domain.models.Todo
import com.jonathan.todos.domain.models.TodoResponse
import com.jonathan.todos.domain.services.TodoService
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity(), TodoListContract.View {

    @Inject
    lateinit var todoInteractor: TodoInteractor

    private lateinit var todoListPresenter: TodoListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_main)
        todoListPresenter = TodoListPresenter(todoInteractor, this)
        todoListPresenter.getTodo()
    }

    override fun showTodos(list: List<Todo>) {
        todoList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoListAdapter(list)
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showErrorMessage(error: Throwable) {
        emptyOrErrorState.text = "ERROR: ${error.message}"
    }

}

/**
 * sealed class Response {
 *   object Waiting: Response()
 *   class Result(data: Any): Response()
 *   class Error(error: Throwable): Response()
 * }
 */

/**
 * Todo(.......)
 * Service(...)
 * InteractWithService
 * Display result
 *
 * Retrofit
 *    HttpLoggingInterceptor
 *    HttpClient
 *    GsonConverter()
 *    RxJava CallAdpater()
 *
 *    => Observer and display
 */

/**
 * constructor() { }
 *
 *
 * componentDidMount() {  }
 *
 *
 * render() {
 * }
 */


/**
 * onCreate() {}
 * onStart()
 * onResume()
 * onPause()
 * onStop()
 * onDestroy()
 */
