package com.basbas.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date()
    }

    private fun date() {

        val sdf = SimpleDateFormat("dd MMM  yyyy   ", Locale.getDefault())
        val currentDateandTime = sdf.format(Date())
        tv_tanngal?.text = currentDateandTime

    }
}
