package binar.and.lima.chapterenam.pertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import binar.and.lima.chapterenam.R
import kotlinx.android.synthetic.main.activity_latihan_satu.*
import kotlinx.android.synthetic.main.activity_main.*

class ActivityLatihanSatu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_satu)
        ThreadHitungUmur()

    }

    fun ThreadHitungUmur() {

      Thread(Runnable {

            btnhitunglatsatu.setOnClickListener {
                val nama = et_namalatsatu.text.toString()
                val thnlahir = et_tahunlahirlatsatu.text.toString().toInt()
                val hasil = 2022 - thnlahir

                tv_namalatsatu.post(Runnable {
                    tv_namalatsatu.text = nama
                })

                tv_hasilumurlatsaty.post(Runnable {
                    tv_hasilumurlatsaty.text = hasil.toString()
                })
            }

        } ).start()
    }


}





