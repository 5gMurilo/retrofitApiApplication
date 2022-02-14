package com.murilocardoso.workingwithapis.api

import com.murilocardoso.workingwithapis.model.Membros
import retrofit2.Call
import retrofit2.http.GET

interface MembersAPI {
    @GET("members")
    fun getMembers(): Call<List<Membros>>
}