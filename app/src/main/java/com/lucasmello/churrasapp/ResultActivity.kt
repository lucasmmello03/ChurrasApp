package com.lucasmello.churrasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasmello.churrasapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalCarne = intent.getDoubleExtra("totalCarne", 0.0) // Corrigido para Double
        val duraçãoDoChurrasco = intent.getIntExtra("duraçãoDoChurrasco", 0)
        val numAdultos = intent.getIntExtra("numAdultos", 0)
        val numCrianças = intent.getIntExtra("numCrianças", 0)

        binding.tvResultNumAdultos.text = "Adultos: $numAdultos"
        binding.tvResultNumCriancas.text = "Crianças: $numCrianças"
        binding.tvDuracaoDoChurrasco.text = "Duração: $duraçãoDoChurrasco horas"
        binding.tvTotalCarne.text = "Carne necessária (Kg): %.2f".format(totalCarne) // Formatação correta

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}
