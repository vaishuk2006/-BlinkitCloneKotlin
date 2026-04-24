package com.example.blinkitclone

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.etName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val address = findViewById<EditText>(R.id.etAddress)
        val btn = findViewById<Button>(R.id.btnRegister)

        btn.setOnClickListener {

            if (name.text.isEmpty() || phone.text.isEmpty() || address.text.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("name", name.text.toString())
                intent.putExtra("phone", phone.text.toString())
                intent.putExtra("address", address.text.toString())

                startActivity(intent)
            }
        }
    }
}