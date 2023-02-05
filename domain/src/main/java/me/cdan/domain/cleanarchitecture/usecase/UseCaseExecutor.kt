package me.cdan.domain.cleanarchitecture.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.cdan.domain.cleanarchitecture.exception.DomainException
import me.cdan.domain.cleanarchitecture.exception.UnknownDomainException
import kotlin.coroutines.cancellation.CancellationException

/**
 * UseCaseExecutor is a class that handles the execution of use cases in a coroutine.
 * It allows for the use cases to be executed in a background thread, and it also provides a way to handle any exceptions
 * that may be thrown during the execution of the use case. It also allows for callbacks to be provided for when the use case
 * execution is successful.
 * @param coroutineScope: CoroutineScope, the scope to launch the coroutine on
 * @method execute: overloaded method, takes a use case, an input value and callbacks, launch a coroutine in the given scope
 * and try to execute the use case with the input value. If the execution is successful, the "onSuccess" callback is called
 * with the output of the use case. If an exception is thrown, the "onException" callback is called with the exception.
 *
 */
class UseCaseExecutor(
    private val coroutineScope: CoroutineScope
) {
    fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        execute(useCase, Unit, onSuccess, onException)
    }

    fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        coroutineScope.launch {
            try {
                useCase.execute(value, onSuccess)
            } catch (ignore: CancellationException) {
            } catch (throwable: Throwable) {
                onException(
                    (throwable as? DomainException)
                        ?: UnknownDomainException(throwable)
                )
            }
        }
    }
}
