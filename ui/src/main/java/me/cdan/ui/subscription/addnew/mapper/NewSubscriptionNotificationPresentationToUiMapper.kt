package me.cdan.ui.subscription.addnew.mapper

import me.cdan.presentation.subscription.model.NewSubscriptionPresentationNotification
import me.cdan.ui.architecture.mapper.NotificationPresentationToUiMapper
import me.cdan.ui.architecture.model.NotificationUiModel

class NewSubscriptionNotificationPresentationToUiMapper : NotificationPresentationToUiMapper<NewSubscriptionPresentationNotification> {
    override fun toUi(presentationNotification: NewSubscriptionPresentationNotification): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}