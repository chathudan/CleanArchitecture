package me.cdan.ui.subscription.addnew.binder

import me.cdan.presentation.subscription.model.NewSubscriptionViewState
import me.cdan.ui.architecture.mapper.ViewStateBinder

class NewSubscriptionViewStateBinder : ViewStateBinder<NewSubscriptionViewState, NewSubscriptionViewsProvider> {
    override fun NewSubscriptionViewsProvider.bindState(viewState: NewSubscriptionViewState) = Unit
}