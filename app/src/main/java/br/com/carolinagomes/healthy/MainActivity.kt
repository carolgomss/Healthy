package br.com.carolinagomes.healthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcular.setOnClickListener {
            val weight = edtMainPeso.text.toString().trim()
            val height = edtMainAltura.text.toString()

            if(weight.isEmpty()){
                edtMainPeso.error = "Campo obrigatório"
                edtMainPeso.requestFocus()
            } else if(height.isEmpty()){
                edtMainAltura.error = "Campo obrigatório"
                edtMainAltura.requestFocus()
            } else {
                val result : Float = weight.toFloat() / (height.toFloat() * height.toFloat())

                val mIntent = Intent(this, ResultActivity::class.java)
                mIntent.putExtra("INTENT_RESULT", result)
                startActivity(mIntent)
            }
        }

        }
}