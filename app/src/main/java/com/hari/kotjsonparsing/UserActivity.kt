package com.hari.kotjsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hari.kotjsonparsing.adapter.UserAdapter
import com.hari.kotjsonparsing.model.UserModel
import kotlinx.android.synthetic.main.activity_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        user_recycler.layoutManager = LinearLayoutManager(this)

        val retrofit : Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://jsonplaceholder.typicode.com/").build()
        val apiClient : APIClient = retrofit.create(APIClient::class.java)

        val call : Call<ArrayList<UserModel>> = apiClient.getUsers()
        call.enqueue(object : Callback<ArrayList<UserModel>>{
            override fun onFailure(call: Call<ArrayList<UserModel>>?, t: Throwable?) {

                Snackbar.make(root_constraint_users, "Failed", Snackbar.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ArrayList<UserModel>>?, response: Response<ArrayList<UserModel>>?) {

                val usersList : ArrayList<UserModel> = response?.body() ?: arrayListOf()
                user_recycler.adapter = UserAdapter(this@UserActivity, usersList)

                Snackbar.make(root_constraint_users, "Success", Snackbar.LENGTH_LONG).show()

            }
        })
    }
}