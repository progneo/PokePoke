package me.progneo.pokepoke.common.presentaion.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : LifecycleObserver, ViewModel() {
    protected fun <T> call(
        useCaseCall: suspend () -> Result<T>,
        onSuccess: ((T) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    ) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            try {
                val result = useCaseCall.invoke()

                result.getOrNull()?.let { value ->
                    onSuccess?.invoke(value)
                }

                result.exceptionOrNull()?.let { error ->
                    onError?.invoke(error)
                }
            } catch (ex: Exception) {
                onError?.invoke(ex)
            }
        }
    }
}
