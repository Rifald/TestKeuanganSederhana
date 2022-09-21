package com.example.testnutapos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnutapos.data.UangMasuk
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private  var uangMasukList = emptyList<UangMasuk>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))

    }

    override fun getItemCount(): Int {
        return uangMasukList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = uangMasukList[position]
        holder.itemView.id_txt.text = currentItem.UangMasukid.toString()
        holder.itemView.terima_txt.text = currentItem.TerimaDari
        holder.itemView.keterangan_txt.text = currentItem.Keterangan
        holder.itemView.jumlah_txt.text = currentItem.Jumlah.toString()
    }
    fun setData(uangMasuk:List<UangMasuk>){
        this.uangMasukList = uangMasuk
        notifyDataSetChanged()
    }


}