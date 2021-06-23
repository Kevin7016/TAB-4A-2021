package com.example.practica6

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.CountDownTimer
import android.view.View


class BaseP(p:MainActivity): View(p)
{
    var toque=false
    var xd=360f
    var yd=50f
    var arriba= false

    override fun onDraw(c: Canvas)
    {

        object : CountDownTimer(200, 100) {
            override fun onTick(millisUntilFinished: Long) {
                if (!arriba) {
                    //xd+=20f
                    yd += 20f
                    choque(yd, xd)

                }

                if (arriba) {
                    //xd+=20f
                    yd -= 20f
                    choque(yd, xd)

                }
                invalidate()
            }
            override fun onFinish() {

            }

        }.start()



        super.onDraw(c)
        val p= Paint()
        c.drawColor(Color.BLACK)
        p.color= Color.WHITE
        c.drawCircle(xd, yd, 23f,p)
        p.color= Color.WHITE
        c.drawRoundRect(RectF(300f, 60f, 500f, 20f), 6f, 6f, p)
        p.color= Color.WHITE
        c.drawRoundRect(RectF(150f, 2060f, 350f, 2100f), 6f, 6f, p)
    }

    private fun choque(y: Float,x: Float) {
        if (yd>=2340)
        {
            yd= 2340F

            arriba=true
        }
        if (yd<=0)
        {
            yd= 0F

            arriba =false
        }

    }

}