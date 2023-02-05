package me.cdan.datasource.subscription.service

import me.cdan.datasource.subscription.model.SubscriptionRequestApiModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SubscriptionService {
    @POST("/fakeAuth")
    fun addNewSubscription(@Body newSubscription: SubscriptionRequestApiModel): Call<String>
}