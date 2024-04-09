package com.example.androidtechnicalexamination.ui.component

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidtechnicalexamination.data.room.user.UserEntity
import com.example.androidtechnicalexamination.databinding.ListItemUserBinding
import com.squareup.picasso.Picasso

class UsersListAdapter constructor(
    val userList: List<UserEntity>,
    val onUserClick: (id: String) -> Unit
) : Adapter<UsersListAdapter.UserItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(
            ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.lblUserName.text = user.firstName
        val city = user.city
        val country = user.country
        holder.binding.lblUserAddress.text = "$city, $country"
        Picasso.get().load(user.thumbnail).into(holder.binding.imgUser);
    }

    class UserItemViewHolder(val binding: ListItemUserBinding) : ViewHolder(binding.root) { }
}