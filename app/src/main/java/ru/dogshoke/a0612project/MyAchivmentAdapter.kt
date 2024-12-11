package ru.dogshoke.a0612project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAchievmentAdapter(val achievments: Array<Achievment?>) : RecyclerView.Adapter<MyAchievmentAdapter.AchievmentHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievmentHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.adapter_item,parent,false)
        return AchievmentHolder(view)
    }

    override fun onBindViewHolder(holder: AchievmentHolder, position: Int) {
        val achievment = achievments[position]
        holder.a.setText(achievment?.name)
        holder.b.setText(achievment?.date)
    }

    override fun getItemCount(): Int {
        return achievments.size
    }

    inner class AchievmentHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val a : TextView
        val b : TextView
        init{
            a = itemView.findViewById(R.id.name)
            b = itemView.findViewById(R.id.date)
        }
    }
}