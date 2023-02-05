package me.cdan.domain.cleanarchitecture.usecase

import kotlinx.coroutines.withContext
import me.cdan.domain.cleanarchitecture.coroutine.CoroutineContextProvider

abstract class BackgroundExecutingUseCase<REQUEST, RESULT>(
    private val coroutineContextProvider: CoroutineContextProvider
) : UseCase<REQUEST, RESULT> {
    final override suspend fun execute(
        input: REQUEST,
        onResult: (RESULT) -> Unit
    ) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(input)
        }
        onResult(result)
    }

    abstract fun executeInBackground(
        request: REQUEST
    ): RESULT
}
