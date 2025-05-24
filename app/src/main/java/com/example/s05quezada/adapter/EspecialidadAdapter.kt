package com.example.s05quezada.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s05quezada.Especialidad
import com.example.s05quezada.R

//class EspecialidadAdapter(private val especialidadList:List<Especialidad>):RecyclerView.Adapter<EspecialidadViewHolder> (){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspecialidadViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        return EspecialidadViewHolder(layoutInflater.inflate(R.layout.item_especialidad, parent,false))
//    }
//
//    override fun getItemCount(): Int = especialidadList.size
//
//    override fun onBindViewHolder(holder: EspecialidadViewHolder, position: Int) {
//        val item = especialidadList[position]
//        holder.render(item)
//    }
//}

class EspecialidadAdapter(
    private val especialidadOriginal: List<Especialidad>
) : RecyclerView.Adapter<EspecialidadViewHolder>() {

    private val especialidadesFiltradas = mutableListOf<Especialidad>().apply { addAll(especialidadOriginal) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspecialidadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EspecialidadViewHolder(layoutInflater.inflate(R.layout.item_especialidad, parent,false))
    }

    override fun getItemCount(): Int = especialidadesFiltradas.size

    override fun onBindViewHolder(holder: EspecialidadViewHolder, position: Int) {
        val item = especialidadesFiltradas[position]
        holder.render(item)
    }

    fun updateList(nuevaLista: List<Especialidad>) {
        especialidadesFiltradas.clear()
        especialidadesFiltradas.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}
