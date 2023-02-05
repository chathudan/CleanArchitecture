package me.cdan.data.adnewsubscription.mapper

import me.cdan.data.subscription.model.SubscriptionRequestDataModel
import me.cdan.domain.subscription.model.NewSubscriptionDomainModel

class NewSubscriptionDomainToSubscriptionRequestDataMapper {
    fun toData(subscription : NewSubscriptionDomainModel) = SubscriptionRequestDataModel(
        fullName = subscription.fullName,
        email = subscription.email
    )
}