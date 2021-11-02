package com.poirot.project.githubuserapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poirot.project.githubuserapp.databinding.ListUserDicodingBinding

class ListUserAdapter : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    var dicodingusers = arrayListOf<DicodingUser>()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val listUserDicodingBinding = ListUserDicodingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listUserDicodingBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(dicodingusers[position])

    override fun getItemCount(): Int = dicodingusers.size

    class ListViewHolder(var binding: ListUserDicodingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: DicodingUser){
            binding.tvUsername.text = user.usrname
            binding.tvRealname.text = user.name
            binding.tvCompany.text = user.company
            Glide.with(binding.root)
                .load(user.avatar)
                .into(binding.ava)

            binding.root.setOnClickListener{
                val intent = Intent(itemView.context, DetailUser::class.java)
                intent.putExtra(DetailUser.EXTRA_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}

