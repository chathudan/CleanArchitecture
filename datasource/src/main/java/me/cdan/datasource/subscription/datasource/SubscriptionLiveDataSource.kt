package me.cdan.datasource.subscription.datasource

import me.cdan.data.subscription.datasource.SubscriptionDataSource
import me.cdan.data.subscription.model.SubscriptionRequestDataModel
import me.cdan.data.subscription.model.SubscriptionResponseDataModel
import me.cdan.datasource.subscription.mapper.SubscriptionRequestToDataApiMapper
import me.cdan.datasource.subscription.service.SubscriptionService

class SubscriptionLiveDataSource(
    private val subscriptionService: SubscriptionService,
    private val subscriptionRequestToDataApiMapper: SubscriptionRequestToDataApiMapper
) : SubscriptionDataSource{

    override fun addNewSubscription(subscription: SubscriptionRequestDataModel): SubscriptionResponseDataModel {
       val apiSubscription = subscriptionRequestToDataApiMapper.toApi(subscription)
        var response = subscriptionService.addNewSubscription(apiSubscription).execute()

        return subscriptionRequestToDataApiMapper.toData(response.body() ?: throw IllegalStateException("Saving the subscription failed."))
    }
}