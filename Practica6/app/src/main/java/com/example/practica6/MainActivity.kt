package com.example.practica6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(BaseP(this))
        varc()
    }
    private fun varc()
    {
        var salsa= "Salsa"
        println(salsa)
        var game: BaseP? = null

    }

}