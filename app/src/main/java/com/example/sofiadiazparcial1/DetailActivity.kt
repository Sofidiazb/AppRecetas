package com.example.sofiadiazparcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var nombreDetail : TextView
    private lateinit var platoDetail : ImageView
    private lateinit var ingredienteDetail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        nombreDetail = findViewById(R.id.tv_nombre_detail)
        ingredienteDetail = findViewById(R.id.tv_ingredientes_detail)
        platoDetail = findViewById(R.id.iv_plato_detail)

        nombreDetail.text = receta?.nombre
        ingredienteDetail.text = receta?.ingredientes

        Glide.with(this).load(receta?.plato).into(platoDetail)
    }
}