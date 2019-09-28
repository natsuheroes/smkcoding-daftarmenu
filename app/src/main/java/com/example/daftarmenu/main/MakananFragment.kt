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
import kotlinx.android.synthetic.main.makanan_fragment.rv_makanan

class MakananFragment : Fragment() {

    companion object {
        fun getInstance(): MakananFragment {
            return MakananFragment()
        }
    }

    val dataMakanan = mutableListOf<MenuModel>()
    val rvAdapter = RvAdapter(dataMakanan)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout.makanan_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter = rvAdapter
        rv_makanan.layoutManager = LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData() {
        dataMakanan.add(MenuModel(
                "Mie-miean",
                "Rp. 5.000",
                R.drawable.mie
            )
        )
        dataMakanan.add(MenuModel(
                "Sayur-sayuran",
                "Rp. 3.000",
                R.drawable.sayur
            )
        )
        dataMakanan.add(MenuModel(
                "Nasi",
                "Rp. 2.000",
                R.drawable.nasi
            )
        )


        rvAdapter.notifyDataSetChanged()
    }
}