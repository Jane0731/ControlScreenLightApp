package com.example.a0303_application

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UVApiService{

    @GET("Taichung/12")
    @Headers("Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJER2lKNFE5bFg4WldFajlNNEE2amFVNm9JOGJVQ3RYWGV6OFdZVzh3ZkhrIn0.eyJleHAiOjE2ODQzODkzNzYsImlhdCI6MTY4NDMwMjk3NiwianRpIjoiYTJkZjkwMzktZDU1Yy00N2NlLThmNTItMTM0NWQ2ZDc2MWQ0IiwiaXNzIjoiaHR0cHM6Ly90ZHgudHJhbnNwb3J0ZGF0YS50dy9hdXRoL3JlYWxtcy9URFhDb25uZWN0Iiwic3ViIjoiODk5ZDU3N2YtMDNlYS00OWI0LTk3MzAtNWM4NThhYjI4ZjRjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiczEzMTEwNjEwMjAtOWUyZGRkZTYtZjBiMS00NmM5IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJzdGF0aXN0aWMiLCJwcmVtaXVtIiwibWFhcyIsImFkdmFuY2VkIiwidmFsaWRhdG9yIiwiaGlzdG9yaWNhbCIsImJhc2ljIl19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJ1c2VyIjoiOTMzZTMzYTIifQ.bRRAeNL_I7Ctzuwq2djwN1pOk41ccw-LdJSyY6Pf3UnHevMXHMmlzaE00uCoOLq_Y5RF8ZkFI44YPjisJpfo8uXKATCCc2d3cWFurZ0XSwLmozhDNjmJoKzq5F35dhfz0ykEynXTlIdxd6B9ZP13-_ydNt7zOeFUfCy-RcATvUBwHYhzwyu-LLXy8xFY_GrMPdkab1SslwRBNrcYPgVvLuKLgNViKDNSUCKmAXrTF9rkCUypX2ohLHAYhxNy1OhT5ukO0dn34_RqeAQWBOA02ebRbMpa1aKHHsPIw48l5B54tr4Z9l4kFP7Hzg10qnrPCd5pyS5yinNPW9TwFdegEA")
    fun getUV(
        @Query("top") top:String?=null,
        @Query("format")  format:String
    ):Call<List<BusData>>
}

private const val BASE_URL ="https://tdx.transportdata.tw/api/basic/v2/Bus/EstimatedTimeOfArrival/City/"

object UVApi{
//    private val client=OkHttpClient.Builder()
//        .addInterceptor(MyInterceptor("Bearer", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJER2lKNFE5bFg4WldFajlNNEE2amFVNm9JOGJVQ3RYWGV6OFdZVzh3ZkhrIn0.eyJleHAiOjE2ODQzODkzNzYsImlhdCI6MTY4NDMwMjk3NiwianRpIjoiYTJkZjkwMzktZDU1Yy00N2NlLThmNTItMTM0NWQ2ZDc2MWQ0IiwiaXNzIjoiaHR0cHM6Ly90ZHgudHJhbnNwb3J0ZGF0YS50dy9hdXRoL3JlYWxtcy9URFhDb25uZWN0Iiwic3ViIjoiODk5ZDU3N2YtMDNlYS00OWI0LTk3MzAtNWM4NThhYjI4ZjRjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiczEzMTEwNjEwMjAtOWUyZGRkZTYtZjBiMS00NmM5IiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJzdGF0aXN0aWMiLCJwcmVtaXVtIiwibWFhcyIsImFkdmFuY2VkIiwidmFsaWRhdG9yIiwiaGlzdG9yaWNhbCIsImJhc2ljIl19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJ1c2VyIjoiOTMzZTMzYTIifQ.bRRAeNL_I7Ctzuwq2djwN1pOk41ccw-LdJSyY6Pf3UnHevMXHMmlzaE00uCoOLq_Y5RF8ZkFI44YPjisJpfo8uXKATCCc2d3cWFurZ0XSwLmozhDNjmJoKzq5F35dhfz0ykEynXTlIdxd6B9ZP13-_ydNt7zOeFUfCy-RcATvUBwHYhzwyu-LLXy8xFY_GrMPdkab1SslwRBNrcYPgVvLuKLgNViKDNSUCKmAXrTF9rkCUypX2ohLHAYhxNy1OhT5ukO0dn34_RqeAQWBOA02ebRbMpa1aKHHsPIw48l5B54tr4Z9l4kFP7Hzg10qnrPCd5pyS5yinNPW9TwFdegEA"))
//        .build()
    private val retrofit = Retrofit.Builder()
//        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService:UVApiService= retrofit.create(UVApiService::class.java)
}