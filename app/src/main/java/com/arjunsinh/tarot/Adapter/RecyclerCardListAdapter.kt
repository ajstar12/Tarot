package com.arjunsinh.tarot.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

class RecyclerCardListAdapter(var list : List<CardModel>) : RecyclerView.Adapter<RecyclerCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

        }
    }
}