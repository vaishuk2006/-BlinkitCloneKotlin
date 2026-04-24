package com.example.blinkitclone

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.blinkitclone.model.Product

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        @Suppress("UNCHECKED_CAST")
        val list = intent.getSerializableExtra("list") as? ArrayList<Product> ?: arrayListOf()

        val tvItems = findViewById<TextView>(R.id.tvItems)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val btn = findViewById<Button>(R.id.btnOrder)

        var total = 0
        val builder = StringBuilder()

        for (p in list) {
            if (p.quantity > 0) {
                builder.append("${p.name} x${p.quantity}\n")
                total += p.price * p.quantity
            }
        }

        tvItems.text = builder.toString()
        tvTotal.text = "Total: ₹$total"

        btn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Success")
                .setMessage("Order Placed Successfully ✅")
                .setCancelable(false)
                .setPositiveButton("OK", null)
                .show()
        }
    }
}