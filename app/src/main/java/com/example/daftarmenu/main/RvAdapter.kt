package com.example.daftarmenu.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarmenu.R
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_menu.iv_mie
import kotlinx.android.synthetic.main.item_list_menu.tv_hargamie
import kotlinx.android.synthetic.main.item_list_menu.tv_mie

class RvAdapter(private val data: List<MenuModel>) :
    RecyclerView.Adapter<RvAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_list_menu,
                    parent, false
                )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView)
        , LayoutContainer {

        fun bindData(item: MenuModel) {
            tv_mie.text = item.namaMenu
            tv_hargamie.text = item.hargaMenu
            iv_mie.setImageResource(item.gambarMenu)

            itemView.setOnClickListener {
                Toast.makeText(containerView.context,item.namaMenu,Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}