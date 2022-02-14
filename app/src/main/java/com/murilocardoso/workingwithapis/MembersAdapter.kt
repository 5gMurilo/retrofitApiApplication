package com.murilocardoso.workingwithapis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.murilocardoso.workingwithapis.model.Membros

class MembersAdapter(
    private val context : Context,
    private val productList: List<Membros>
) : RecyclerView.Adapter<MembersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder =
        MembersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.member_item, parent,false))


    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
        val item = productList[position]
        holder.memberName.text = item.nome
        holder.memberAge.text = "idade ${item.idade}"
        Glide.with(context).load(item.foto).into(holder.memberImage)
    }
}

class MembersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val memberImage : ImageView = itemView.findViewById(R.id.member_image)
    val memberName : TextView = itemView.findViewById(R.id.member_name)
    val memberAge : TextView = itemView.findViewById(R.id.member_age)
}