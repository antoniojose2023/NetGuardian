package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.netguardian.databinding.ActivityLinkUteisBinding

class LinkUteisActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLinkUteisBinding.inflate(layoutInflater) }
    private var link: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configurarClickViews()

        binding.tvTituloTelaLink.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }

    fun configurarClickViews(){

        binding.tvDicaUm.setOnClickListener{
            link =  "https://jrs.digital/sociedade-brasileira-de-computacao-lista-6-dicas-para-navegar-com-seguranca-em-dispositivos-moveis/"
            executarLink(link)
        }

        binding.tvDicaDois.setOnClickListener{
            link =  "https://www.tecmundo.com.br/seguranca/233922-cinco-dicas-navegacao-segura-internet.htm"
            executarLink(link)
        }

        binding.tvDicaTres.setOnClickListener{
            link =  "https://sumus.com.br/seguranca-movel-6-dicas-para-proteger-seus-dados-contra-invasoes/"
            executarLink(link)
        }

        binding.tvDicaQuatro.setOnClickListener{
            link =  "https://www.youtube.com/watch?v=y4rYFzJ8JIk"
            executarLink(link)
        }
    }

    fun executarLink(link: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(intent)
    }
}