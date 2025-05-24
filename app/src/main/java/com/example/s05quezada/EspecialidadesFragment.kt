package com.example.s05quezada

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s05quezada.adapter.EspecialidadAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EspecialidadesFragment : Fragment() {

    private lateinit var adapter: EspecialidadAdapter
    private val listaOriginal = EspecialidadProvider.especialidades

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_especialidades, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvDoctor)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = EspecialidadAdapter(listaOriginal)
        recyclerView.adapter = adapter

        val etBuscar = view.findViewById<EditText>(R.id.etBuscar)
        val btnTodos = view.findViewById<Button>(R.id.btnTodos)
        val btnTopRated = view.findViewById<Button>(R.id.btnTopRated)
        val btnMasExperiencia = view.findViewById<Button>(R.id.btnMasExperiencia)

        etBuscar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                val filtrados = listaOriginal.filter {
                    it.nameDoctor.contains(query, ignoreCase = true) ||
                            it.especialidad.contains(query, ignoreCase = true)
                }
                adapter.updateList(filtrados)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        btnTodos.setOnClickListener {
            adapter.updateList(listaOriginal)
        }

        btnTopRated.setOnClickListener {
            val topRated = listaOriginal.filter { it.calificacion >= 4.5f }
            adapter.updateList(topRated)
        }

        btnMasExperiencia.setOnClickListener {
            val masExperiencia = listaOriginal.sortedByDescending { it.experienciaAnios }
            adapter.updateList(masExperiencia)
        }

        return view
    }
}
