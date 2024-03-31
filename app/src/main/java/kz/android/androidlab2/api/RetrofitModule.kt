package kz.android.androidlab2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}