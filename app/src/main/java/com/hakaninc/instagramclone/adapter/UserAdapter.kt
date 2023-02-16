package com.hakaninc.instagramclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hakaninc.instagramclone.R
import com.hakaninc.instagramclone.databinding.UserItemLayoutBinding
import com.hakaninc.instagramclone.model.User
import com.squareup.picasso.Picasso


class UserAdapter (private val mContext : Context,
                   private var mUser : List<User>,
                   private val isFragment: Boolean = false) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = UserItemLayoutBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = mUser[position]
        holder.binding.userNameSearch.text = user.username
        holder.binding.userFullNameSearch.text = user.fullname
        Picasso.get().load(user.image).placeholder(R.drawable.profile)
            .into(holder.binding.userProfileImageSearch)

    }

    override fun getItemCount(): Int {
        return mUser.size
    }

    class ViewHolder(val binding : UserItemLayoutBinding) :RecyclerView.ViewHolder(binding.root){


    }

}