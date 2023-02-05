package me.cdan.datasource.subscription.model

import com.google.gson.annotations.SerializedName

data class SubscriptionRequestApiModel(
    @SerializedName("name")
    val fullName: String,

    @SerializedName("email")
    val email: String
)