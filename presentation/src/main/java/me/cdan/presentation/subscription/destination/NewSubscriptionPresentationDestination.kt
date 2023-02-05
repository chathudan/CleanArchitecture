package me.cdan.presentation.subscription.destination

import me.cdan.presentation.architecture.model.PresentationDestination
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationModel

sealed interface NewSubscriptionPresentationDestination : PresentationDestination{
    data class NewSubscriptionCreateSuccess(
        val subscription : NewSubscriptionPresentationModel
    )
}