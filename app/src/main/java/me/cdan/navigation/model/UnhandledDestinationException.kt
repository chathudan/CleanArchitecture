package me.cdan.navigation.model

import me.cdan.presentation.architecture.model.PresentationDestination


class UnhandledDestinationException(
    destination: PresentationDestination
) : IllegalArgumentException(
    "Navigation to ${destination::class.simpleName} was not handled."
)