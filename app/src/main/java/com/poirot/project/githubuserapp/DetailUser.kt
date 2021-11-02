package com.poirot.project.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.poirot.project.githubuserapp.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail User Dicoding"
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setData() {
        val dataUser = intent.getParcelableExtra<DicodingUser>(EXTRA_USER) as DicodingUser

        with(binding) {
            Glide.with(root)
                .load(dataUser.avatar)
                .into(imageAva)
            tvUsrname.text = dataUser.usrname
            tvname.text = dataUser.name
            tvcompany.text = dataUser.company
            tvlocation.text = dataUser.location
            tvrepo.text = dataUser.repo
            tvfollowers.text = dataUser.followers
            tvfollowing.text = dataUser.following
        }
    }
}