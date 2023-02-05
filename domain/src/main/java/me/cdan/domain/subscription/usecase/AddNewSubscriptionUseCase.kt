package me.cdan.domain.subscription.usecase

import me.cdan.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import me.cdan.domain.cleanarchitecture.usecase.BackgroundExecutingUseCase
import me.cdan.domain.subscription.model.NewSubscriptionDomainModel
import me.cdan.domain.subscription.repository.AddNewSubscriptionRepository

class AddNewSubscriptionUseCase(
    private val addNewSubscriptionRepository: AddNewSubscriptionRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<NewSubscriptionDomainModel, NewSubscriptionDomainModel>(
    coroutineContextProvider
) {
    override fun executeInBackground(request: NewSubscriptionDomainModel) =
        addNewSubscriptionRepository.addNewSubscription(request)
}