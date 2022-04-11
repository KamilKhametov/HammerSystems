package com.example.hammersystems.library.coreui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

abstract class BaseViewModel<S : BaseViewState, E : BaseViewEvent>(
    initialState: S,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main,
) : ViewModel() {

    private val _viewState = MutableStateFlow(initialState)
    private val viewState: StateFlow<S> get() = _viewState

    protected val intent =
        MutableSharedFlow<E>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    init {
        intent.onEach(::observe).launchIn(viewModelScope)
    }

    protected abstract fun observe(event: E)

    fun perform(viewEvent: E) = intent.tryEmit(viewEvent)
    fun viewState(): StateFlow<S> = viewState

    protected fun updateState(block: S.() -> S) {
        _viewState.value = block.invoke(viewState.value)
    }

    protected fun updateStateFromIo(block: S.() -> S) {
        viewModelScope.launch(context = mainDispatcher) {
            _viewState.value = block.invoke(viewState.value)
        }
    }

    protected fun launchCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job {
        return viewModelScope.launch {
            body()
        }
    }

    protected fun launchIOCoroutine(
        body: suspend CoroutineScope.() -> Unit,
    ): Job {
        return launchCoroutine {
            withContext(ioDispatcher) {
                body()
            }
        }
    }
}