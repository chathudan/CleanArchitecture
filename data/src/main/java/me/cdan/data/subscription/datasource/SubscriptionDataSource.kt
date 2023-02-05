package me.cdan.data.subscription.datasource

import me.cdan.data.subscription.model.SubscriptionRequestDataModel
import me.cdan.data.subscription.model.SubscriptionResponseDataModel

interface SubscriptionDataSource {
    fun  addNewSubscription(subscription: SubscriptionRequestDataModel) : SubscriptionResponseDataModel
}