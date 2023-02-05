package me.cdan.ui.subscription.addnew.view

import android.view.View
import android.widget.TextView
import me.cdan.ui.architecture.view.ViewsProvider

interface NewSubscriptionViewsProvider : ViewsProvider {
    val fullNameInput : TextView
    val emailInput : TextView
    val submitButton: View
}