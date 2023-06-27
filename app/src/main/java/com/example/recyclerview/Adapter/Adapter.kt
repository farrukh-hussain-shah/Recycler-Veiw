package com.example.recyclerview.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Activity2
import com.example.recyclerview.Model.ExampleItem
import com.example.recyclerview.R
import com.example.recyclerview.Utils.Contants

class ExampleAdapter(val context: Context,val element:MutableList<ExampleItem>)
    : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
     val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)//Not Neccesary to rememnber all this code becuse we just put this code agian and againr
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
     val currentItem=element[position]
        holder.title.text=currentItem.title
     holder.description.text=currentItem.description
    }

    override fun getItemCount(): Int {
    return element.size
    }
    inner class ExampleViewHolder(view:View):RecyclerView.ViewHolder(view){
        val title:TextView=view.findViewById(R.id.title)
        val description:TextView=view.findViewById(R.id.description)

        init {
            view.setOnClickListener{
                val position=adapterPosition
                val items=element[position]
                //TODO in this Intent we context instead of this because we are not in Activity we are in File
                val intent=Intent(context,Activity2::class.java)
                intent.putExtra(Contants.KEY_TITLE,items.title)
                intent.putExtra(Contants.KEY_DESCRIPTION,items.description)

                context.startActivity(intent)
            }
        }
    }
}