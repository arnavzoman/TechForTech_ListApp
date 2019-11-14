package com.application.zomato.listapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_user.view.*

/**
 * created by championswimmer on 2019-11-14
 * Copyright (c) 2019 Zomato Media Pvt. Ltd.
 */
class UserAdapter() :
    ListAdapter<UsersResponse.Data, UserAdapter.UserViewHolder>(UserDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        Log.d("USERS", "onCreateViewHolder")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.d("USERS", "onBindViewHolder")
        val currentUser = getItem(position)
        holder.itemView.tvName.text = currentUser.firstName + " " + currentUser.lastName
        holder.itemView.tvEmail.text = currentUser.email
    }



    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class UserDiffCallback: DiffUtil.ItemCallback<UsersResponse.Data>() {
        override fun areItemsTheSame(oldItem: UsersResponse.Data, newItem: UsersResponse.Data): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UsersResponse.Data, newItem: UsersResponse.Data): Boolean {
            return oldItem == newItem
        }
    }

}