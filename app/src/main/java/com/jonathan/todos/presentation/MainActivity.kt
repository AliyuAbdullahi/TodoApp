package com.jonathan.todos.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.todos.App
import com.jonathan.todos.R
import com.jonathan.todos.domain.models.Todo
import com.jonathan.todos.domain.services.TodoService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var todoService: TodoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_main)
        displayItemsOnList()
    }

    private fun displayItemsOnList() {
        todoService.getTodos().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    displayList(it)
                },
                {
                    Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
                }
            )
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
