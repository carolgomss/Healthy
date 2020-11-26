package br.com.carolinagomes.healthy

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("INTENT_RESULT", 0.0f);

        val resultString = String.format("%.2f", result)
        if (result != null) {
            if (result < 18.5 ){
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorAbaixo))
                txvResultClassificacao.setText("Classificado como ABAIXO DO PESO, acho melhor reforçar o seu feijão com arroz")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.baixopeso))
            } else if (result >= 18.5 && result < 25.0){
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorNormal))
                txvResultClassificacao.setText("Classificado como PESO NORMAL, olha só esse corpinho!")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.fit))
            } else if (result >= 25.0 && result < 30.0){
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorSobrepeso))
                txvResultClassificacao.setText("Classificado como SOBREPESO, não dá bobeira pra esse peso não!")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.sobrepeso))
            } else if (result >= 30.0 && result < 35.0){
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorObesidade))
                txvResultClassificacao.setText("Classificado como OBESIDADE I, precisamos cuidar desse corpo!")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.fat))
            } else if (result >= 35.0 && result < 40.0){
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorObesidade))
                txvResultClassificacao.setText("Classificado como OBESIDADE II, acho melhor você procurar orientação médica...")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.fat))
            } else {
                txvResultResultado.setText(resultString)
                txvResultResultado.setTextColor(getColor(R.color.colorObesidade))
                txvResultClassificacao.setText("Classificado como OBESIDADE III, já deixou sua consulta marcada, certo?!")
                imgResultAbaixo.setImageDrawable(getDrawable(R.drawable.fat))
            }
        }

        btnResultVoltar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja mesmo sair?")
                .setPositiveButton("Sair") { _, _ ->
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Não") {_, _ ->}
                .setCancelable(true)
                .show()
        }

    }
}