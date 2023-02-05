package me.cdan.presentation.subscription.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import me.cdan.domain.subscription.model.NewSubscriptionDomainModel
import me.cdan.domain.subscription.usecase.AddNewSubscriptionUseCase
import me.cdan.presentation.architecture.viewmodel.BaseViewModel
import me.cdan.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider
import me.cdan.presentation.subscription.mapper.NewSubscriptionPresentationToDomainMapper
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationModel
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationNotification
import me.cdan.presentation.subscription.model.NewSubscriptionViewState
import javax.inject.Inject

@HiltViewModel
class NewSubscriptionViewModel @Inject constructor(
    private val addNewSubscriptionUseCase: AddNewSubscriptionUseCase,
    private val newSubscriptionPresentationToDomainMapper: NewSubscriptionPresentationToDomainMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<NewSubscriptionViewState, NewSubscriptionPresentationNotification>(
    useCaseExecutorProvider
) {
    override fun initialState() = NewSubscriptionViewState ()

    fun onAddNewSubscription(subscription : NewSubscriptionPresentationModel){
        updateViewState(NewSubscriptionViewState::loading)
        addNewSubscription(subscription)
    }

    private fun addNewSubscription(subscription: NewSubscriptionPresentationModel) {
        val domainNewSubscription = newSubscriptionPresentationToDomainMapper.toDomain(subscription)
        execute(addNewSubscriptionUseCase, domainNewSubscription, ::handleNewSubscriptionResult)
    }

    private fun handleNewSubscriptionResult(subscription: NewSubscriptionDomainModel){
        updateViewState(NewSubscriptionViewState::idle)
        // TODO Success
    }
}