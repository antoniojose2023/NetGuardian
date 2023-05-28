package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.antoniojoseuchoa.netguardian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cardDicas.setOnClickListener {
            startActivity(Intent(this, ListagemDicasActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        binding.cardLinks.setOnClickListener {
            exibirMensagem("Tela em construção")
        }

        binding.cardPolitica.setOnClickListener {
            exibirMensagem("Tela em construção")
        }

        binding.cardSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }

    fun exibirMensagem(mensage: String){
        Toast.makeText(this, "$mensage", Toast.LENGTH_SHORT).show()
    }

}