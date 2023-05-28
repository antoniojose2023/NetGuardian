package br.com.antoniojoseuchoa.netguardian.api

import br.com.antoniojoseuchoa.netguardian.domain.Artigo
import retrofit2.http.GET

interface ArtigosApi {
    @GET("artigos.json")
    suspend fun getArtigos(): List<Artigo>
}