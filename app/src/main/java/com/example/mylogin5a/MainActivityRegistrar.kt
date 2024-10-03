package com.example.mylogin5a

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mylogin5a.databinding.ActivityMainRegistrarBinding

class MainActivityRegistrar : AppCompatActivity() {

    private lateinit var bindingRegis: ActivityMainRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRegis = ActivityMainRegistrarBinding.inflate(layoutInflater)
        val view = bindingRegis.root
        setContentView(view)

        //Creamos la conexión a la BD
        val dbServicios = DBHelperAlumno(this)
        //Abrimos la BD para escribir
        val db = dbServicios.writableDatabase

        //Para regresar a la principal
        val intentPrinci = Intent(this, MainActivity::class.java)
        bindingRegis.btnRegistrar.setOnClickListener {
            var user = bindingRegis.txtNewUsuario.getText().toString()
            val pass = bindingRegis.txtNewPassword.getText().toString()
            var corr = bindingRegis.txtCorreo.getText().toString()
            var nom = bindingRegis.txtNombre.getText().toString()
            //Creamos una variable para colocar llave --> valor
            val newReg = ContentValues()
            newReg.put("userLogin", user)
            newReg.put("userPass", pass)
            newReg.put("userEmail", corr)
            newReg.put("userNombre", nom)

            val res = db.insert("usuarios", null, newReg)

            //Cerramos la BD
            db.close()
            //Evaluamos si se hizo el insert mediante la variable res
            if (res.toInt() == -1) {
                Toast.makeText(this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show()
            } else {
                bindingRegis.txtNewUsuario.text.clear()
                bindingRegis.txtNewPassword.text.clear()
                bindingRegis.txtCorreo.text.clear()
                Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_LONG).show()
                startActivity(intentPrinci)
            }
        }

        bindingRegis.btnCancelar.setOnClickListener {
            startActivity(intentPrinci)
        }



    }
}