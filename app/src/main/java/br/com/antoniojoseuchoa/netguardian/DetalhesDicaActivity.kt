package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniojoseuchoa.netguardian.databinding.ActivityDetalhesDicaBinding
import br.com.antoniojoseuchoa.netguardian.domain.Artigo
import com.bumptech.glide.Glide

class DetalhesDicaActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetalhesDicaBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvTituloTelaDetalhe.setOnClickListener {
            startActivity(Intent(this, ListagemDicasActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        val intent = if(Build.VERSION.SDK_INT == Build.VERSION_CODES.TIRAMISU){
              intent.getParcelableExtra("artigo", Artigo::class.java)
        }else{
             intent.getParcelableExtra("artigo")
        }

        intent?.let { artigo ->
            Glide.with(this).load(artigo.url_imagem).into(binding.ivImagemArtigo)
            binding.tvTituloArtigoDetalhes.text = artigo.title
            binding.tvDescricaoArtigoDetalhe.text = artigo.description

        }

        binding.btFeedback.setOnClickListener {
                enviarEmail()
        }

    }


    fun enviarEmail(){
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.O){
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto")
            intent.setType("message/rfc822")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayListOf("antoniojoseuchoa2023@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sugestões")
            startActivity(Intent.createChooser(intent, "Escolha seu gerenciador de email preferido."))
        }else{
            val url = "antoniojoseuchoa2023@gmail.com"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("mailto:$url")
            startActivity(intent)
        }
    }
}