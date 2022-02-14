package com.murilocardoso.workingwithapis

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murilocardoso.workingwithapis.api.MyRetrofit
import com.murilocardoso.workingwithapis.model.Membros
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerProducts = findViewById(R.id.recyclerProducts)
        recyclerProducts.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        val call: Call<List<Membros>> =
            MyRetrofit.instance?.MemberApi()?.getMembers() as Call<List<Membros>>

        call.enqueue(object : Callback<List<Membros>>{
            override fun onResponse(call: Call<List<Membros>>, response: Response<List<Membros>>) {
                val adapter = MembersAdapter(this@MainActivity,response.body()?.toList() as List<Membros>)
                recyclerProducts.adapter = adapter
            }

            @SuppressLint("ShowToast")
            override fun onFailure(call: Call<List<Membros>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Deu ruim papai ${t.message}", Toast.LENGTH_LONG).show()
                Log.e("Failure on request", t.message.toString())
            }

        })
    }
}