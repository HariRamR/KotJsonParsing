package com.hari.kotjsonparsing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.hari.kotjsonparsing.R
import com.hari.kotjsonparsing.model.UserModel
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserAdapter(var context : Context, var userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false))


    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: MainViewHolder, pos: Int) {

        val titleTv = holder.itemView.title_list_item_user

        if (userList.get(pos).completed != null && userList.get(pos).completed == true){

            titleTv.setTextColor(AppCompatResources.getColorStateList(context, R.color.green))
        }else titleTv.setTextColor(AppCompatResources.getColorStateList(context, R.color.red))

        titleTv.text = userList.get(pos).title
    }
}