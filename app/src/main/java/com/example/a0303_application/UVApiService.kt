package com.example.a0303_application

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface UVApiService{
    @GET("v2/uv_s_01")
    fun getUV(
        @Query("language") lan:String?=null,
        @Query("api_key")  key:String
    ):Call<UVData>
}

private const val BASE_URL ="https://data.epa.gov.tw/api/"

object UVApi{
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val retrofitService:UVApiService= retrofit.create(UVApiService::class.java)
}