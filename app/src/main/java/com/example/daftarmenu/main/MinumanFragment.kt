package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.synthetic.main.minuman_fragment.rv_minuman

class MinumanFragment: Fragment() {
    companion object{
        fun getInstance(): MinumanFragment {
            return MinumanFragment()
        }
    }
    val dataMinuman = mutableListOf<MenuModel>()
    val rvAdapter = RvAdapter(dataMinuman)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.minuman_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_minuman.adapter= rvAdapter
        rv_minuman.layoutManager = LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData() {
        dataMinuman.add(MenuModel("Es Teh",
            "Rp. 2.500",
            R.drawable.esteh
        ))
        dataMinuman.add(MenuModel("Air",
            "Rp. 2.000",
            R.drawable.air
        ))
        dataMinuman.add(MenuModel("Ciu",
            "Rp. 550.000",
            R.drawable.ciu
        ))

        rvAdapter.notifyDataSetChanged()
    }
}