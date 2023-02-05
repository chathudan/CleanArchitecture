package me.cdan.domain.subscription.repository

import me.cdan.domain.subscription.model.NewSubscriptionDomainModel

interface AddNewSubscriptionRepository {
    fun  addNewSubscription( subscription : NewSubscriptionDomainModel): NewSubscriptionDomainModel
}