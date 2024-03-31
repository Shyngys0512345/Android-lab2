package kz.android.androidlab2.models

import com.google.gson.annotations.SerializedName

data class Celebrity(
    val name: String? =null,
    @SerializedName("net_worth") val netWorth: Long? = null,
    val gender: String? =null,
    val nationality: String? = null,
    val occupation: List<String>? = null,
    val height: Double?= null,
    val birthday: String? = null,
)
