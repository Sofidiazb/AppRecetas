package com.example.clase6_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.bumptech.glide.Glide
import com.example.sofiadiazparcial1.Pais
import com.example.sofiadiazparcial1.R
import com.example.sofiadiazparcial1.Receta


class Adapter(val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val plato: ImageView = view.findViewById(R.id.iv_plato)
        private val nombre: TextView = view.findViewById(R.id.tv_nombre_receta)
        private val dificultad: TextView = view.findViewById(R.id.tv_dificultad)
        private val pais: TextView = view.findViewById(R.id.tv_pais)
        private val logo: ImageView = view.findViewById(R.id.iv_pais)

        fun bind (receta: Receta) {

            nombre.text = receta.nombre
            dificultad.text = receta.dificultad.toString()
            pais.text = receta.pais.toString()

            val imagen = when (receta.pais) {
                    Pais.ARGENTINA -> R.drawable.arg
                    Pais.VENEZUELA -> R.drawable.vzla
                    Pais.MEXICO -> R.drawable.mex
                    Pais.PERU -> R.drawable.per
                    else -> {
                    }
                }

            logo.setImageResource(imagen as Int)
            Glide.with(context).load(receta.plato).into(plato)

            view.setOnClickListener{
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}
