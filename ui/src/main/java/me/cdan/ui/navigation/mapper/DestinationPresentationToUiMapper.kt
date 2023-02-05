package me.cdan.ui.navigation.mapper

import me.cdan.presentation.architecture.model.PresentationDestination
import me.cdan.ui.navigation.model.UiDestination

interface DestinationPresentationToUiMapper {
    fun toUi(input: PresentationDestination): UiDestination
}
