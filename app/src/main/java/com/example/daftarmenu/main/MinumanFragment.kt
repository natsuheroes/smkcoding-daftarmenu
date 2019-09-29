package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.R.layout
import com.example.daftarmenu.adapter.RvAdapterMakanan
import com.example.daftarmenu.adapter.RvAdapterMinuman
import com.example.daftarmenu.data.MenuDB
import com.example.daftarmenu.data.MenuMakananModel
import com.example.daftarmenu.data.MenuMinumanModel
import kotlinx.android.synthetic.main.makanan_fragment.rv_makanan
import kotlinx.android.synthetic.main.minuman_fragment.rv_minuman

class MinumanFragment: Fragment() {
    companion object{
        fun getInstance(): MinumanFragment {
            return MinumanFragment()
        }
    }

    val dataMinuman = mutableListOf<MenuMinumanModel>()
    val mRvAdapterMinuman = RvAdapterMinuman(dataMinuman)
    var db: MenuDB? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.minuman_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_minuman.adapter = mRvAdapterMinuman
        rv_minuman.layoutManager = LinearLayoutManager(context)

        db = MenuDB.getInstance(context!!)
        getMenuMinuman()

    }

    private fun getMenuMinuman() {
        db?.menuDao()?.ambilMenuMinuman()?.observe(this, Observer { hasil ->
            when(hasil.size==0){
                true ->{
                    Toast.makeText(context,"Data Makanan masih kosong",
                        Toast.LENGTH_SHORT).show()
                }
                false ->{
                    dataMinuman.clear()
                    dataMinuman.addAll(hasil)
                    mRvAdapterMinuman.notifyDataSetChanged()

                }
            }

        })
    }
}