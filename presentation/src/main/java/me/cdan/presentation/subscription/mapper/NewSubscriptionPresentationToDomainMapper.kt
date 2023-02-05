package me.cdan.presentation.subscription.mapper

import me.cdan.domain.subscription.model.NewSubscriptionDomainModel
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationModel

class NewSubscriptionPresentationToDomainMapper {
    fun toDomain(newSubscription : NewSubscriptionPresentationModel) =
        NewSubscriptionDomainModel(fullName = newSubscription.fullName,
            email = newSubscription.email
        )
}