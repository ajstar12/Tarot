package com.arjunsinh.tarot.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arjunsinh.tarot.Activity.CardDetailsActivity
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.Utils.Constant
import com.arjunsinh.tarot.databinding.RecyclerCardListSingleBinding

class RecyclerCardListAdapter(var list : List<CardModel>) : RecyclerView.Adapter<RecyclerCardListAdapter.ViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        var binding = RecyclerCardListSingleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pojo = list[holder.absoluteAdapterPosition]

        holder.binding.txtCardName.text = pojo.card_name

        val drawableId = Constant.cardImages[pojo.image]
        if (drawableId != null) {
            holder.binding.imgCard.setImageResource(drawableId)
        }else{
            Constant.log("card_Image", "pojo.image : "+pojo.image)
        }

        holder.itemView.setOnClickListener {
            var intent = Intent(context, CardDetailsActivity::class.java)
            intent.putExtra("card_details",pojo)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ViewHolder(itemView: View, subBinding: RecyclerCardListSingleBinding) : RecyclerView.ViewHolder(itemView){
        lateinit var binding: RecyclerCardListSingleBinding
        init {
            binding = subBinding
        }
    }
    fun updateData(newList : List<CardModel>){
        list = newList
        notifyDataSetChanged()
    }
}