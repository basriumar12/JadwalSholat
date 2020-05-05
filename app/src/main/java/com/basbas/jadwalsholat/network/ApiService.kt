package com.basbas.jadwalsholat.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{periode}/daily.json")
    fun getJadwalSholat(@Path("periode") periode: String?): Call<String>



}