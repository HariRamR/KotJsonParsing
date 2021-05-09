package com.hari.kotjsonparsing

import com.hari.kotjsonparsing.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {

    @GET("/todos")
    fun getUsers(): Call<ArrayList<UserModel>>
}