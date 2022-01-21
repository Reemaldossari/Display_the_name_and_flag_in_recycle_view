package com.reemsd.display_the_name_and_flag_in_recycle_view.network

import com.reemsd.display_the_name_and_flag_in_recycle_view.Country
import com.reemsd.display_the_name_and_flag_in_recycle_view.DataFlag
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

// this is url to bring data from web.
private const val BASE_URL = "https://countriesnow.space/api/v0.1/countries/flag/"

//this is moshi convert json into kotlin object .
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

//we need retrofit to talk to web server and receive data in json format
// and addConverterFactory will converted data to kotlin object useing moshi
//and baseUrl(BASE_URL) the link of data.

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()








// interface definte how retrofit talk to web srever using http request.
interface ApiSerivce{
    @GET("images")
    suspend fun getPhoto():DataFlag
}

object CountryApi {
    val retrofitSerivce :ApiSerivce by lazy {
        retrofit.create(ApiSerivce::class.java)
    }
}