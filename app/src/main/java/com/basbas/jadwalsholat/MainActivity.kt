package com.basbas.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.basbas.jadwalsholat.model.Items
import com.basbas.jadwalsholat.model.ResponseJadwalSholat
import com.basbas.jadwalsholat.network.ApiRetrofit
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date()
        getdata()
    }

    private fun getdata() {
        progress_circular.visibility = View.VISIBLE
        ApiRetrofit.create().getJadwalSholat("Gorontalo")
            .enqueue(object : Callback<ResponseJadwalSholat>{
                override fun onFailure(call: Call<ResponseJadwalSholat>?, t: Throwable?) {
                    Toast.makeText(this@MainActivity,
                        "Gagal mendapatkan data", Toast.LENGTH_LONG).show()
                    progress_circular.visibility = View.GONE
                }

                override fun onResponse(call: Call<ResponseJadwalSholat>?, response: Response<ResponseJadwalSholat>?) {
                   //validasi
                    if (response?.isSuccessful!!){
                        progress_circular.visibility = View.VISIBLE
                        Log.e("TAG","hasil data ${Gson().toJson(response.body())}")
                        //isi value
                        txtSubuh.text = response.body().items?.get(0)?.fajr
                        txtAshar.text = response.body().items?.get(0)?.asr
                        txtDzuhur.text = response.body().items?.get(0)?.dhuhr
                        txtMaghrib.text = response.body().items?.get(0)?.maghrib
                        txtIsya.text = response.body().items?.get(0)?.isha


                    }else{
                        Toast.makeText(this@MainActivity,
                            "Gagal mendapatkan data", Toast.LENGTH_LONG).show()
                    }

                }
            })
    }

    private fun date() {
        val sdf = SimpleDateFormat("dd MMM  yyyy   ", Locale.getDefault())
        val currentDateandTime = sdf.format(Date())
        tv_tanngal?.text = currentDateandTime

    }
}
