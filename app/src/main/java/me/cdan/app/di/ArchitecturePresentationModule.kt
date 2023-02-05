package me.cdan.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.cdan.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import me.cdan.domain.cleanarchitecture.usecase.UseCaseExecutor
import me.cdan.presentation.architecture.viewmodel.coroutine.AppCoroutineContextProvider
import me.cdan.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider

@Module
@InstallIn(SingletonComponent::class)
class ArchitecturePresentationModule {
    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        AppCoroutineContextProvider()

    @Provides
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider = ::UseCaseExecutor
}
