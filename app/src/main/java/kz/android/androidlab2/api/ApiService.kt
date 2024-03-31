package kz.android.androidlab2.api

import kz.android.androidlab2.models.Celebrity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key:2MA2jRzARqX/oiW2I2fHvQ==Y18edTDbrhAWLRLd")
    @GET("celebrity")
    fun getCelebritiesByName(@Query("name") name: String): Call<List<Celebrity>>
}