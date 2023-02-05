package me.cdan.datasource.subscription.mapper

import me.cdan.data.subscription.model.SubscriptionRequestDataModel
import me.cdan.data.subscription.model.SubscriptionResponseDataModel
import me.cdan.datasource.subscription.model.SubscriptionRequestApiModel

class SubscriptionRequestToDataApiMapper {
    fun toApi(subscription: SubscriptionRequestDataModel) = SubscriptionRequestApiModel(
        fullName =  subscription.fullName,
        email = subscription.email
    )

    // TODO : response needs to update
    fun toData( response: String) = SubscriptionResponseDataModel(
        id = 0,
        fullName = response,
        email = response
    )

}