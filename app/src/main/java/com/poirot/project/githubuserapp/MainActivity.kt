package com.poirot.project.githubuserapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.poirot.project.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListUserAdapter
    private lateinit var listUserName: Array<String>
    private lateinit var listName: Array<String>
    private lateinit var listLocation: Array<String>
    private lateinit var listAvatar: TypedArray
    private lateinit var listRepo: Array<String>
    private lateinit var listCompany: Array<String>
    private lateinit var listFollowers: Array<String>
    private lateinit var listFollowing: Array<String>

    private lateinit var binding: ActivityMainBinding
    private var listuser = arrayListOf<DicodingUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListUserAdapter()
        setDataArray()
        addList()
    }

    private fun setListUserAdapter() {
        adapter = ListUserAdapter()
        with(binding) {
            rvUser.adapter = adapter
            rvUser.layoutManager =
                LinearLayoutManager(this@MainActivity)
            rvUser.setHasFixedSize(true)
        }
    }

    private fun setDataArray() {
        listUserName = resources.getStringArray(R.array.username)
        listName = resources.getStringArray(R.array.name)
        listLocation = resources.getStringArray(R.array.location)
        listAvatar = resources.obtainTypedArray(R.array.avatar)
        listRepo = resources.getStringArray(R.array.repository)
        listCompany = resources.getStringArray(R.array.company)
        listFollowers = resources.getStringArray(R.array.followers)
        listFollowing = resources.getStringArray(R.array.following)
    }

    private fun addList() {
        for (position in listUserName.indices) {
            val dicodingUser = DicodingUser(
                listUserName[position], listName[position], listLocation[position], listAvatar.getResourceId(position, -1), listRepo[position], listCompany[position], listFollowers[position], listFollowing[position]
            )
            listuser.add(dicodingUser)
        }
        adapter.dicodingusers = listuser
    }
}