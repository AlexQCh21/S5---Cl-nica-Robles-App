package com.example.s05quezada

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavBarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nav_bar, container, false)
        val btnHome = view.findViewById<LinearLayout>(R.id.btnHome)
        val btnLista = view.findViewById<LinearLayout>(R.id.btnLista)
        val btnAcercaDe = view.findViewById<LinearLayout>(R.id.btnAcercaDe)
        val barra1 = view.findViewById<View>(R.id.barra1)
        val barra2 = view.findViewById<View>(R.id.barra2)
        val barra3 = view.findViewById<View>(R.id.barra3)

        barra2.visibility = View.GONE
        barra3.visibility = View.GONE

        btnHome.setOnClickListener {
            (activity as? HomeActivity)?.showHome()
            barra1.visibility = View.VISIBLE
            barra2.visibility = View.GONE
            barra3.visibility = View.GONE
        }

        btnLista.setOnClickListener {
            (activity as? HomeActivity)?.showEspecialidades()
            barra2.visibility = View.VISIBLE
            barra1.visibility = View.GONE
            barra3.visibility = View.GONE
        }

        btnAcercaDe.setOnClickListener {
            (activity as? HomeActivity)?.showAcercaDe()
            barra3.visibility = View.VISIBLE
            barra2.visibility = View.GONE
            barra1.visibility = View.GONE
        }

        return view // <--- esta es la línea correcta
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavBarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavBarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}