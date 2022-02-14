package com.murilocardoso.workingwithapis.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    private val retrofit: Retrofit

    fun MemberApi(): MembersAPI {
        return retrofit.create(MembersAPI::class.java)
    }

    companion object {
        private const val BASE_URL: String = "https://jsonserver-simple-api.herokuapp.com/"

        var myRetrofit: MyRetrofit? = null

        @get:Synchronized
        val instance: MyRetrofit?
            get() {
                if (myRetrofit == null) {
                    myRetrofit = MyRetrofit()
                }
                return myRetrofit
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}