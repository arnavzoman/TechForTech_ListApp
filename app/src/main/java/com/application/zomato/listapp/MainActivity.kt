package com.application.zomato.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = r.create(ReqResAPI::class.java)
        val userAdapter = UserAdapter()

        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = userAdapter

        btnSearch.setOnClickListener {
            val requiredItems = etCity.text.toString().toInt()

            api.getUsers(requiredItems).enqueue(object: Callback<UsersResponse> {
                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Response failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {

                    Toast.makeText(this@MainActivity, "Response successful", Toast.LENGTH_SHORT).show()

                    userAdapter.submitList(response.body()?.data)
                }

            })

        }
    }
}
