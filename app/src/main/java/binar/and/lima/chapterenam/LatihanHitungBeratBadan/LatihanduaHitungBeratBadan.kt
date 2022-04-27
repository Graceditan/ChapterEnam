package binar.and.lima.chapterenam.LatihanHitungBeratBadan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import binar.and.lima.chapterenam.R
import binar.and.lima.chapterenam.pertama.ActivityLatihanSatu
import kotlinx.android.synthetic.main.activity_latihan_satu.*
import kotlinx.android.synthetic.main.activity_latihandua_hitung_berat_badan.*
import kotlinx.android.synthetic.main.activity_main.*

class LatihanduaHitungBeratBadan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihandua_hitung_berat_badan)
      //  HandlerLatDua()
        threadlatdua()
    }


    fun HandlerLatDua(){
        //Handler(Looper.getMainLooper()).postDelayed(Runnable {
        //    startActivity(Intent(this, ActivityLatihanSatu::class.java))
       // }, 3000)

        Handler(Looper.getMainLooper()).post(Runnable {
            btnhitunglatdua.setOnClickListener {
                val bb = et_beratbdnlatdua.text.toString().toInt()
                val tb = et_beratbdnlatdua.text.toString().toInt()
                val bmi = bb / (tb*tb)

                if (bmi > 18.5 )
                { Handler().post(Runnable {
                    tv_ketindeksbrtbdn.setText("Kurus ")
                })
                }else if (18.5 >= bmi && bmi <= 24.9)
                {Handler().post(Runnable {
                    tv_ketindeksbrtbdn.setText("Normal ")
                })
                }else if(25 >= bmi && bmi <= 29.9){
                    Handler().post(Runnable {
                        tv_ketindeksbrtbdn.setText("Over Weight ")
                    })
                }else{
                    Handler().post(Runnable {
                        tv_ketindeksbrtbdn.setText("Obesitas ")
                    })

                }

            }

        })
    }
    fun threadlatdua(){
        Thread(Runnable {
            btnhitunglatdua.setOnClickListener {

                val bbt = et_beratbdnlatdua.text.toString().toInt()
                val tbt = et_beratbdnlatdua.text.toString().toInt()
                val bmit = bbt / (tbt*tbt)
                if(bmit>18.5){
                    tv_ketindeksbrtbdn.post(Runnable {
                        tv_ketindeksbrtbdn.text = "kurus"
                    })
                }else if (18.5 >= bmit && bmit <= 24.9){
                    tv_ketindeksbrtbdn.post(Runnable {
                        tv_ketindeksbrtbdn.text = "normal"
                    })

                }else if (25 >= bmit && bmit <= 29.9){
                    tv_ketindeksbrtbdn.post(Runnable {
                        tv_ketindeksbrtbdn.text = "over weight"
                    })
                }else{
                    tv_ketindeksbrtbdn.post(Runnable {
                        tv_ketindeksbrtbdn.text = "obesitas"
                    })
                }




            }



        }).start()








    }




}