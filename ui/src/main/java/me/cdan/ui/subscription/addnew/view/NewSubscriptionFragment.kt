package me.cdan.ui.subscription.addnew.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationNotification
import me.cdan.presentation.subscription.model.NewSubscriptionViewState
import me.cdan.presentation.subscription.viewmodel.NewSubscriptionViewModel
import me.cdan.ui.architecture.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import me.cdan.presentation.subscription.model.NewSubscriptionPresentationModel
import me.cdan.ui.R
import me.cdan.ui.architecture.mapper.ViewStateBinder
import me.cdan.ui.architecture.view.ViewsProvider
import me.cdan.ui.subscription.addnew.mapper.NewSubscriptionDestinationToUiMapper
import me.cdan.ui.subscription.addnew.mapper.NewSubscriptionNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class NewSubscriptionFragment :
    BaseFragment<NewSubscriptionViewState, NewSubscriptionPresentationNotification>(),
    NewSubscriptionViewsProvider {

    override val viewModel: NewSubscriptionViewModel by viewModels()

    override lateinit var fullNameInput: TextView
    override lateinit var emailInput: TextView
    override lateinit var submitButton: View

    @Inject
    override lateinit var destinationMapper: NewSubscriptionDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper: NewSubscriptionNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder: ViewStateBinder<NewSubscriptionViewState, ViewsProvider>

    override val layoutResourceId = R.layout.fragment_new_subscription

    override fun View.bindViews() {
        fullNameInput = findViewById(R.id.new_subscription_name_field)
        emailInput = findViewById(R.id.new_subscription_email_field)
        submitButton = findViewById(R.id.new_subscription_submit_button)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        submitButton.setOnClickListener{
            viewModel.onAddNewSubscription(
                NewSubscriptionPresentationModel(
                    fullName = fullNameInput.text.toString(),
                    email = emailInput.text.toString()
                )
            )
        }

        return view
    }
}