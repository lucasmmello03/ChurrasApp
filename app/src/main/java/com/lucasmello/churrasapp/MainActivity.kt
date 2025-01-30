package com.lucasmello.churrasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lucasmello.churrasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun calcular() {
        val numAdultos = binding.tilNumDeAdultos.editText?.text.toString().toIntOrNull() ?: 0
        val numCrianças = binding.tilNumDeCriancas.editText?.text.toString().toIntOrNull() ?: 0
        val duraçãoDoChurrasco = binding.tilDuraDoChurrasco.editText?.text.toString().toIntOrNull() ?: 0

        if (numAdultos > 0 && duraçãoDoChurrasco > 0) {
            val carnePorAdulto = if (duraçãoDoChurrasco > 4) 400 else 300
            val carnePorCrianca = if (duraçãoDoChurrasco > 4) 150 else 100

            val totalCarne = (numAdultos * carnePorAdulto) + (numCrianças * carnePorCrianca)

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("totalCarne", totalCarne / 1000.0) // Convertendo para kg antes de enviar
                putExtra("duraçãoDoChurrasco", duraçãoDoChurrasco)
                putExtra("numAdultos", numAdultos)
                putExtra("numCrianças", numCrianças)
            }
            startActivity(intent)

        } else {
            Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
        }
    }
}
