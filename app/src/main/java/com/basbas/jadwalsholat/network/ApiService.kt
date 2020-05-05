package com.basbas.jadwalsholat.network

import com.basbas.jadwalsholat.model.Items
import com.basbas.jadwalsholat.model.ResponseJadwalSholat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{path}/daily.json")
    fun getJadwalSholat(@Path("path") periode: String?):
            Call<ResponseJadwalSholat>


    //optional
    @GET("Gorontalo/daily.json")
    fun getJadwalSholatGorontalo() :
            Call<Items>



}