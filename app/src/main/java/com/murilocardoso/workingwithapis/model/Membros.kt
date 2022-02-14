package com.murilocardoso.workingwithapis.model

import com.google.gson.annotations.SerializedName

data class Membros (
    @SerializedName("id")
    val id: Int,
    @SerializedName("nome")
    val nome: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("idade")
    val idade: Int
        )