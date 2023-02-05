package me.cdan.presentation.architecture.viewmodel.usecase

import kotlinx.coroutines.CoroutineScope
import me.cdan.domain.cleanarchitecture.usecase.UseCaseExecutor

typealias UseCaseExecutorProvider =
        @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
