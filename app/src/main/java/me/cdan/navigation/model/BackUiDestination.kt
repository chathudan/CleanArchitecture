package me.cdan.navigation.model

import androidx.navigation.NavController
import dagger.Lazy
import me.cdan.ui.navigation.model.UiDestination

class BackUiDestination(
    private val lazyNavController: Lazy<NavController>
) : UiDestination {
    override fun navigate() {
        lazyNavController.get().popBackStack()
    }
}
