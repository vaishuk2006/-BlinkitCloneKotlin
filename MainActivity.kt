package com.example.blinkitclone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkitclone.adapter.ProductAdapter
import com.example.blinkitclone.model.Product

class MainActivity : AppCompatActivity() {

    lateinit var productList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val address = intent.getStringExtra("address")

        productList = arrayListOf(
            Product("Apple", 60, R.drawable.apple),
            Product("Banana", 400, R.drawable.banana),
            Product("Rice", 120, R.drawable.rice),
            Product("MilkBottle", 40, R.drawable.milkbottle),
            Product("Bread", 50, R.drawable.bread),
            Product("Eggs", 60, R.drawable.eggs),
            Product("Spinach", 30, R.drawable.spinach),
            Product("Potato", 55, R.drawable.potato)
        )

            //RecyclerView
            val recycler = findViewById<RecyclerView>(R.id.recyclerView)
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = ProductAdapter(productList)

        val cartBtn = findViewById<Button>(R.id.btnCart)

        intent.putExtra("name", name)
        intent.putExtra("phone", phone)
        intent.putExtra("address", address)

        cartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("list", ArrayList(productList))
            startActivity(intent)
        }
    }
}