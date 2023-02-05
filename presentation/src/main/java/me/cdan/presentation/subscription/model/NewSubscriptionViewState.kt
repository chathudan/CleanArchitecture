package me.cdan.presentation.subscription.model

data class NewSubscriptionViewState(
    val isLoading: Boolean = false
) {
    fun loading() = copy(isLoading = true)

    fun idle() = copy(isLoading = false)
}
