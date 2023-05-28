package br.com.antoniojoseuchoa.netguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.netguardian.databinding.ActivitySobreBinding

class SobreActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySobreBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.tvTituloSobre.setOnClickListener {
           startActivity(Intent(this, MainActivity::class.java))
           overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
       }

    }
}