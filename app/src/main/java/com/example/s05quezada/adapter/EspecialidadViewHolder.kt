package com.example.s05quezada.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.s05quezada.Especialidad
import com.example.s05quezada.R

class EspecialidadViewHolder (view:View):RecyclerView.ViewHolder(view){

    val especialidad = view.findViewById<TextView>(R.id.tvDescripcionEspecialidad)
    val doctor = view.findViewById<TextView>(R.id.tvNombreDoctor)
    val photo = view.findViewById<ImageView>(R.id.imgDoctor)
    val calificacion = view.findViewById<TextView>(R.id.tvCalificacion)
    val exp = view.findViewById<TextView>(R.id.tvExperiencia)
    fun render(item:Especialidad){
        especialidad.text = item.especialidad
        doctor.text = "Dr. ${item.nameDoctor} ${item.apellido}"
        Glide.with(photo.context).load(item.imagen).circleCrop().into(photo)
        calificacion.text = item.calificacion.toString().trim()
        exp.text = "${item.experienciaAnios.toString()} años de experiencia"

    }
}