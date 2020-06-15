package com.jonathan.todos.domain.models

import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("completed")
    val completed: Boolean? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
)



