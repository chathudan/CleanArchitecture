package me.cdan.data.adnewsubscription.mapper

import me.cdan.data.subscription.model.SubscriptionResponseDataModel
import me.cdan.domain.subscription.model.NewSubscriptionDomainModel

class SubscriptionResponseToNewSubscriptionDomainDataMapper {
    fun toDomain(response: SubscriptionResponseDataModel ) = NewSubscriptionDomainModel(
        fullName = response.fullName,
        email = response.email
    )
}