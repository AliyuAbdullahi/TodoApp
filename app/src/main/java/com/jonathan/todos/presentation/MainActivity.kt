package com.jonathan.todos.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.todos.App
import com.jonathan.todos.R
import com.jonathan.todos.domain.models.Todo
import com.jonathan.todos.domain.models.TodoResponse
import com.jonathan.todos.domain.services.TodoService
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var todoInteractor: TodoInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        displayItemsOnList()
    }

    private fun showErrorMessage(error: Throwable) {
        Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        Toast.makeText(this, "Loading....", Toast.LENGTH_SHORT).show()
    }

    private fun hideLoading() {
        //hide whatever we are using to show loading
    }

    private fun displayItemsOnList() {
        todoInteractor.todoObservable.subscribe { todoResponse ->
            when (todoResponse) {
                is TodoResponse.Success -> displayList(todoResponse.data as List<Todo>)
                is TodoResponse.Pending -> showLoading()
                is TodoResponse.Error -> showErrorMessage(todoResponse.error)
            }
        }
    }

    private fun displayList(list: List<Todo>) {
        todoList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoListAdapter(list)
        }
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
