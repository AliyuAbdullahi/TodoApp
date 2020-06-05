package com.jonathan.todos.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jonathan.todos.R
import com.jonathan.todos.domain.models.Todo

class TodoListAdapter(private val todos: List<Todo>) :
    RecyclerView.Adapter<TodoListAdapter.TodoListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false)
        return TodoListItemViewHolder(view)
    }

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(holder: TodoListItemViewHolder, position: Int) {
        holder.bindItem(todos[position])
    }

    class TodoListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.todoTitle)
        var done: TextView = view.findViewById(R.id.todoDone)

        fun bindItem(todo: Todo) {
            title.text = todo.title
            todo.completed?.let {
                if (it) {
                    done.setTextColor(ContextCompat.getColor(done.context, R.color.green))
                    done.text = title.context.getString(R.string.done)
                } else {
                    done.setTextColor(ContextCompat.getColor(done.context, R.color.red))
                    done.text = title.context.getString(R.string.pending)
                }
            }
        }
    }
}
