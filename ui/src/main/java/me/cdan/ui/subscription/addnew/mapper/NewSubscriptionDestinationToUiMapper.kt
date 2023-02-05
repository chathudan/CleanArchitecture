package me.cdan.ui.subscription.addnew.mapper

import me.cdan.presentation.subscription.model.NewSubscriptionPresentationModel
import me.cdan.ui.navigation.mapper.DestinationPresentationToUiMapper
import me.cdan.ui.navigation.model.UiDestination

interface NewSubscriptionDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class NewSubscriptionSuccessUiDestination(
         open val subscriptionId : String
    ) : UiDestination
}