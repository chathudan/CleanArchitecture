package me.cdan.navigation.mapper

import androidx.navigation.NavController
import dagger.Lazy
import me.cdan.navigation.model.UnhandledDestinationException
import me.cdan.presentation.architecture.model.PresentationDestination
import me.cdan.ui.navigation.mapper.DestinationPresentationToUiMapper
import me.cdan.ui.navigation.model.UiDestination

class GlobalDestinationToUiMapper(
    private val lazyNavController: Lazy<NavController>
) : DestinationPresentationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        PresentationDestination.Back -> BackUiDestination(lazyNavController)
        else -> throw UnhandledDestinationException(input)
    }

    private class BackUiDestination(
        private val lazyNavController: Lazy<NavController>
    ) : UiDestination {
        override fun navigate() {
            lazyNavController.get().popBackStack()
        }
    }
}