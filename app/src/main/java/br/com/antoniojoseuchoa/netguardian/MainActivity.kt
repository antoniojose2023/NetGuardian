package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import android.net.Uri
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
            startActivity(Intent(this, LinkUteisActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        binding.cardPolitica.setOnClickListener {
            val link = "https://docs.google.com/document/d/1K9EpM1tEuunky9Xidw3EuJ4evuhpQUVW/edit?usp=share_link&ouid=116151650051955729705&rtpof=true&sd=true"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
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