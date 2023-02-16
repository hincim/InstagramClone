package com.hakaninc.instagramclone.model

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class User ( val username :String,
                  val fullname : String,
                  val bio : String,
                  val image : String,
                  val uid : String)


