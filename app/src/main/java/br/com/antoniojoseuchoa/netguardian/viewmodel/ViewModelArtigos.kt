package br.com.antoniojoseuchoa.netguardian.viewmodel

import androidx.lifecycle.ViewModel
import br.com.antoniojoseuchoa.netguardian.repository.RepositoryArtigos

class ViewModelArtigos: ViewModel() {
    fun getArtigos() = RepositoryArtigos.getArtigos()
}