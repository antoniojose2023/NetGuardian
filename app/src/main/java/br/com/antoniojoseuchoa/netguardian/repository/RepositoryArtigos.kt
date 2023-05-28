package br.com.antoniojoseuchoa.netguardian.repository

import androidx.lifecycle.liveData
import br.com.antoniojoseuchoa.netguardian.api.RetrofitService
import br.com.antoniojoseuchoa.netguardian.domain.Artigo

object RepositoryArtigos {
    fun getArtigos() = liveData {
        emit(States.Loader)

        try{
            emit(States.OnSucess(RetrofitService.retrofit.getArtigos()))
        }catch (ex: java.lang.Exception){
            emit(States.OnError(ex.message.toString()))
        }
    }

}

sealed class States{
    object Loader: States()
    class OnSucess(val list: List<Artigo>): States()
    class OnError(val mensage: String): States()
}

