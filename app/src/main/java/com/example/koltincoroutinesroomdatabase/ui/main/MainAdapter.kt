package com.example.koltincoroutinesroomdatabase.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.koltincoroutinesroomdatabase.R
import com.example.koltincoroutinesroomdatabase.data.local.entity.User
import com.example.koltincoroutinesroomdatabase.ui.userdetails.UserDetailsActivity
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.text_created_at.text = user.createdAt
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, UserDetailsActivity::class.java)
                intent.putExtra("id", user.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position])

    fun addUsers(list: List<User>) {
        users.addAll(list)
    }
}