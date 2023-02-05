package me.cdan.data.adnewsubscription.repository

import me.cdan.data.adnewsubscription.mapper.NewSubscriptionDomainToSubscriptionRequestDataMapper
import me.cdan.data.adnewsubscription.mapper.SubscriptionResponseToNewSubscriptionDomainDataMapper
import me.cdan.data.subscription.datasource.SubscriptionDataSource
import me.cdan.domain.subscription.model.NewSubscriptionDomainModel
import me.cdan.domain.subscription.repository.AddNewSubscriptionRepository

class AddNewSubscriptionLiveRepository(
    private  val subscriptionDataSource : SubscriptionDataSource,
    private val newSubscriptionDomainToSubscriptionRequestDataMapper: NewSubscriptionDomainToSubscriptionRequestDataMapper,
    private val subscriptionResponseToNewSubscriptionDomainDataMapper: SubscriptionResponseToNewSubscriptionDomainDataMapper
) : AddNewSubscriptionRepository {
    override fun addNewSubscription(subscription: NewSubscriptionDomainModel): NewSubscriptionDomainModel {
        val datasourceRequest = newSubscriptionDomainToSubscriptionRequestDataMapper
            .toData(subscription)

        val dataResponse = subscriptionDataSource.addNewSubscription(datasourceRequest)

        return  subscriptionResponseToNewSubscriptionDomainDataMapper.toDomain(dataResponse)
    }
}