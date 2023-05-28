package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.antoniojoseuchoa.netguardian.adapter.AdapterArtigos
import br.com.antoniojoseuchoa.netguardian.databinding.ActivityListagemDicasBinding
import br.com.antoniojoseuchoa.netguardian.repository.States
import br.com.antoniojoseuchoa.netguardian.viewmodel.ViewModelArtigos

class ListagemDicasActivity : AppCompatActivity() {
    private val binding by lazy { ActivityListagemDicasBinding.inflate(layoutInflater) }
    private val viewModelArtigos by viewModels<ViewModelArtigos>()
    //private lateinit var adapter: AdapterArtigos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       // adapter = AdapterArtigos(this, emptyList())
        binding.swipeRefresh.setOnRefreshListener {
            getArtigos()
        }

        binding.tvTituloTelaListagem.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }

    override fun onStart() {
        super.onStart()
        getArtigos()
    }

    fun getArtigos(){
        viewModelArtigos.getArtigos().observe(this){ states ->
            when(states){
                States.Loader -> binding.swipeRefresh.isRefreshing = true
                is States.OnError -> {
                    exibirMensagem("Erro ao carregando os dados . . .")
                    binding.swipeRefresh.isRefreshing = false
                }
                is States.OnSucess -> {

                     val adapter = AdapterArtigos(this, states.list)
                      binding.rvArtigos.layoutManager = LinearLayoutManager(this)
                      binding.rvArtigos.setHasFixedSize(true)
                      binding.rvArtigos.adapter = adapter
                      binding.swipeRefresh.isRefreshing = false
                      exibirMensagem("Dados carrgados com sucesso . . .")

                      adapter.onclick = { artigo ->
                            val intent = Intent(this, DetalhesDicaActivity::class.java)
                            intent.putExtra("artigo", artigo)
                            startActivity(intent)
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                      }
                }
            }
        }

    }

    fun exibirMensagem(mensagem: String){
        Toast.makeText(this, "$mensagem", Toast.LENGTH_LONG).show()
    }

}