package me.cdan.presentation.architecture.viewmodel.coroutine


import kotlinx.coroutines.Dispatchers
import me.cdan.domain.cleanarchitecture.coroutine.CoroutineContextProvider

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
