package com.jonathan.todos.presentation

import com.jonathan.todos.domain.models.Todo
import com.jonathan.todos.domain.models.TodoResponse
import com.jonathan.todos.domain.services.TodoService
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit

class TodoInteractorTest {

    init {
        MockitoAnnotations.initMocks(this)
    }

    private val todoStub = todo {
        id = 1
        completed = true
    }

    private val todoService: TodoService = mock()

    private lateinit var todoInteractor: TodoInteractor

    @Test
    fun getTodoObservable() {
    }

    @Test
    fun `TodoInteractor returns response with actual data if no error`() {
        whenever(todoService.getTodos()).thenReturn(Observable.just(listOf(todoStub)))

        todoInteractor = TodoInteractor(todoService)
        val testObservable = todoInteractor.todoObservable
        todoInteractor.run()
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        testScheduler.triggerActions()
        val result = testObservable.test()
        result.assertComplete()
        result.assertNoErrors()
    }

    class TodoFactory {
        var id: Int? = null
        var completed: Boolean? = null

        fun build(): Todo = Todo(id = id, completed = completed)
    }

    private fun todo(factory: TodoFactory.() -> Unit) = TodoFactory().apply(factory).build()

    companion object {
        val testScheduler = TestScheduler()

        @BeforeClass
        @JvmStatic
        fun setupTestScheduler() {
            RxJavaPlugins.setInitIoSchedulerHandler { testScheduler }
            RxJavaPlugins.setInitComputationSchedulerHandler { testScheduler }
            RxJavaPlugins.setNewThreadSchedulerHandler { testScheduler }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { testScheduler }
        }

        @AfterClass
        @JvmStatic
        fun resetRxPlugins() {
            RxJavaPlugins.reset()
            RxAndroidPlugins.reset()
        }
    }
}
