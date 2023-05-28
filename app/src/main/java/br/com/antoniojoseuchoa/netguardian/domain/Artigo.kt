package br.com.antoniojoseuchoa.netguardian.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artigo(
    val id: Int,
    val title: String,
    val description: String,
    val url_imagem: String,
    val data: String
):Parcelable{

}