package binar.and.lima.chapterenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import binar.and.lima.chapterenam.pertama.ActivityLatihanSatu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   tvsatu.text = "Hello World"
            // tvdua.text = "welcome,grace"
        contohThreadSatu()
        contohHandler()
    }

    fun contohThreadSatu(){
        Thread(Runnable {

            btnchange.setOnClickListener {
                tvsatu.post(Runnable { tvsatu.text = "Hello BinarAcademy" })
            }
            tvsatu.post(Runnable { tvsatu.text = "Hello World"})
            tvdua.postDelayed(Runnable { tvdua.text = "Welcome,Grace"}, 2000)




        }).start()
    }

    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
          startActivity(Intent(this, ActivityLatihanSatu::class.java))
        }, 3000)

        Handler().post(Runnable {
            tvdua.setText("Helloooo ")
        })
    }

    fun contohhandlerthread(){
        val han = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesandua = msg.obj as String
                tvdua.text = pesandua
            }

        }

        Thread(Runnable {
            val a = "Contoh Handler Thread"
            val pesan = Message.obtain()
            pesan.obj = a

            pesan.target = han
        }).start()
    }

    fun ContohHT(){

        val targethandler = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val  aaa = msg.obj as String
                tvsatu.text = aaa
            }

        }

        Thread(Runnable {
            val aa = Message.obtain()
            aa.obj = "qwerty"
            aa.target = targethandler
            aa.sendToTarget()

          //  Thread(Runnable {
            //    btnchange.setOnClickListener{

              //  val aa = Message.obtain()
                //aa.obj = "qwerty"
                //aa.target = targethandler
                //aa.sendToTarget()}

        }).start()
    }
}