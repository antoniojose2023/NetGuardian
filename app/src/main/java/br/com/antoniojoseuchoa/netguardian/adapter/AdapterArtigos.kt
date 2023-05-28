package br.com.antoniojoseuchoa.netguardian.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.antoniojoseuchoa.netguardian.DetalhesDicaActivity
import br.com.antoniojoseuchoa.netguardian.databinding.ItemArtigoBinding
import br.com.antoniojoseuchoa.netguardian.domain.Artigo

class AdapterArtigos(val context: Context, private val list: List<Artigo>): Adapter<AdapterArtigos.ViewHolder>() {

    var onclick: (artigo: Artigo) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArtigoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(val binding: ItemArtigoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Artigo){
             binding.tvTitulo.text = item.title
             binding.tvDescricao.text = item.description
             binding.tvData.text = item.data

            binding.cardItemArtigo.setOnClickListener {
                   onclick(item)

            }
        }
    }
}