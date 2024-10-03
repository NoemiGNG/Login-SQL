package com.example.mylogin5a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogin5a.databinding.ActivityMainRegistrarBinding

class MainActivityRegistrar : AppCompatActivity() {

    private lateinit var bindingRegis: ActivityMainRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRegis = ActivityMainRegistrarBinding.inflate(layoutInflater)
        setContentView(bindingRegis.root)

        //Para regresar a la principal
        val intentPrinci = Intent(this, MainActivity::class.java)

        bindingRegis.btnCancelar.setOnClickListener {
            startActivity(intentPrinci)
        }



    }
}