package com.example.mylogin5a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogin5a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Cuando hacemos click en registrarse
        binding.tvRegistrarse.setOnClickListener {
            val intentRegistrar = Intent(this, MainActivityRegistrar::class.java)
            startActivity(intentRegistrar)
            //Toast.makeText(this, "Registrarse presionado", Toast.LENGTH_SHORT).show()
        }

    }
}