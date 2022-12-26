package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_hitung.setOnClickListener{
            if(et_angka1.text.toString() == ""){
                et_angka1.error = "Angka 1 Harus Diisi"
                return@setOnClickListener
            }
            if(et_angka2.text.toString() == ""){
                et_angka2.error = "Angka 2 Harus Diisi"
                return@setOnClickListener
            }

            val angka1 = et_angka1.text.toString().toInt()
            val angka2 = et_angka2.text.toString().toInt()
            tv_hasil.text = do_hasil(angka1,angka2)


        }
    }
    private fun do_hasil(nilai1:Int,nilai2:Int):String{
        var hitung_hasil:Int = 0
        val op = sp_operator.selectedItem.toString()

        when(op){
            "+" -> hitung_hasil= nilai1 + nilai2
            "-" -> hitung_hasil= nilai1 - nilai2
            "x" -> hitung_hasil= nilai1 * nilai2
            "/" -> hitung_hasil= nilai1 / nilai2
            else -> {
                Toast.makeText(this,"silahkan Pilih Operator", Toast.LENGTH_SHORT).show()
            }
        }
        val hasil = hitung_hasil
        return hasil.toString()
    }
}