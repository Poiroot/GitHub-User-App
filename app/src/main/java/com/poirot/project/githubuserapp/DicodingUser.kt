package com.poirot.project.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DicodingUser(
    var usrname: String,
    var name: String,
    var location: String,
    var avatar: Int,
    var repo: String,
    var company: String,
    var followers: String,
    var following: String,
):Parcelable
